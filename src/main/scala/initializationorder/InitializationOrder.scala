package initializationorder


trait FooTrait { val num: Int; print(num + " ") }

class Foo extends FooTrait { override val num = 5 }
class FooWithoutNum
class FooWithNum { val num = 5 }
class FooWillExtendNum extends { val num = 5 } with FooTrait

object OrderMain extends App {

  // prints 0
  new Foo()

  // same as above, prints 0
  new FooTrait() { val num = 5 }

  // prints 5
  new { val num = 5 } with FooTrait
  
  // prints 0
  new FooWithoutNum with FooTrait { val num = 5 } 
  
  // prints 5
  new FooWithNum with FooTrait
  
  // prints 5
  new FooWillExtendNum
  
  
  // CONCLUSION:
  // If vals are declared before trait is 'mentioned' when creating new instance of class, 
  // they will be instantiated with given values in the trait.
  
}