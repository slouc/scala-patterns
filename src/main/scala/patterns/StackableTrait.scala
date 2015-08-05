package patterns

abstract class Foo {
  def put(x: Int): Unit
}

/** Class implementation of Foo, prints x **/
class FooImpl extends Foo {
  def put(x: Int) = { println("Original:" + x) }
}

/** Trait implementation of Foo, prints 2x **/
trait Doubler extends Foo {
  def put(x: Int) = { println(2 * x) }
}

/** Stackable decorator of Foo, invokes put with 3x **/
trait Tripler extends Foo {
  abstract override def put(x: Int) = super.put(3 * x)
}

object StackableMain extends App {
  class BarClass extends FooImpl with Doubler with Tripler

  val bar = new BarClass
  
  // Doubler overrides FooImpl (there's no "Original")
  // and Tripler decorates Doubler
  bar.put(1) 
}
