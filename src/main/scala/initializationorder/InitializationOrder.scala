package initializationorder

trait FooTrait { val num: Int; print(num + " ") }

class Foo extends FooTrait { override val num = 5 }
class FooWithoutNum

class FooNumParam(val num: Int) extends FooTrait
class FooWithNum { val num = 5 }
class FooExtendsNum extends { val num = 5 }

abstract class FooAbstract(val num: Int) { print(num + " ") }
abstract class FooAbstract2 { val num: Int; print(num + " ") }

class FooAbstractWithNum(override val num: Int) extends FooAbstract(num)
class FooAbstractWithoutNum extends FooAbstract2 { override val num = 5 }

object OrderMain extends App {

  // these two initialize num when it's too late (in their constructors)
  new Foo()
  new FooWithoutNum with FooTrait { val num = 5 }
  
  // these all initialize num before mixing in FooTrait
  new FooNumParam(5)
  new FooWithNum with FooTrait
  new FooExtendsNum with FooTrait

  println("\n===")
  
  new FooAbstractWithNum(5) // same as with regular class
  new FooAbstractWithoutNum()

  println("\n===")

  // If vals are declared in a pre-initialization block when creating new
  // class instance, they will be instantiated with given values in the trait
  
  new { val num = 5 } with FooTrait
  new FooTrait() { val num = 5 } // no pre-init


}

abstract class Foo2[+T] {
  def process[S >: T](list: S): T
}
