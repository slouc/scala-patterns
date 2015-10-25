package initializationorder


trait FooTrait { val num: Int; print(num + " ") }

class Foo extends FooTrait { override val num = 5 }
class FooNumParam(val num: Int)
class FooWithoutNum
class FooWithNum { val num = 5 }
class FooExtendsNum extends { val num = 5 }

abstract class FooAbstract(val num: Int) { print(num + " ") }
abstract class FooAbstract2 { val num: Int; print(num + " ") }

class FooAbstractWithNum(override val num: Int) extends FooAbstract(num)
class FooAbstractWithoutNum extends FooAbstract2 { override val num = 5 }


object OrderMain extends App {

  new Foo()
  new FooNumParam(5) with FooTrait
  new FooWithoutNum with FooTrait { val num = 5 } 
  new FooWithNum with FooTrait
  new FooExtendsNum with FooTrait
  
  println("\n===")
  
  new FooAbstractWithNum(5)
  new FooAbstractWithoutNum()
  
  println("\n===")
  
  new FooTrait() { val num = 5 }
  new { val num = 5 } with FooTrait
  
  //
  // CONCLUSION:
  // If vals are declared before trait is 'mentioned' when creating new instance of class, 
  // they will be instantiated with given values in the trait.
  
}