package initializationorder


trait FooTrait { val num: Int; println(num) }

class Foo extends FooTrait { override val num = 5 }
class FooWithoutFooTrait
class FooWithoutFooTrait2 { val num = 5 }

object OrderMain extends App {

  // prints 0
  val foo = new Foo()

  // same as above, prints 0
  val foo2 = new FooTrait() { val num = 5 }

  // prints 5
  val foo3 = new { val num = 5 } with FooTrait
  
  // prints 0
  val foo4 = new FooWithoutFooTrait with FooTrait { val num = 5 } 
  
  // prints 5
  val foo5 = new FooWithoutFooTrait2 with FooTrait
  
  // CONCLUSION:
  // If vals are declared before trait is 'mentioned' when creating new instance of class, 
  // they will be instantiated with given values in the trait.
  
}