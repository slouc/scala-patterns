package initializationorder


trait FooTrait { val num: Int; print(num + " ") }

class Foo extends FooTrait { override val num = 5 }
class FooWithoutNum
class FooWithNum { val num = 5 }
class FooWillExtendNum extends { val num = 5 } with FooTrait

abstract class FooAbstract(val num: Int) { print(num + " ") }
abstract class FooAbstract2 { val num: Int; print(num + " ") }

class FooExtendsAbstract(override val num: Int) extends FooAbstract(num)
class FooExtendsAbstract2 extends FooAbstract2 { override val num = 5 }


object OrderMain extends App {

  new Foo()

  new FooTrait() { val num = 5 }

  new { val num = 5 } with FooTrait
  
  new FooWithoutNum with FooTrait { val num = 5 } 
  
  new FooWithNum with FooTrait
  
  new FooWillExtendNum
  
  // same goes for abstract class
  
  new FooExtendsAbstract(5)
  
  new FooExtendsAbstract2()
  
  
  // Prints 0 0 5 0 5 5 5 0
  //
  // CONCLUSION:
  // If vals are declared before trait is 'mentioned' when creating new instance of class, 
  // they will be instantiated with given values in the trait.
  
}