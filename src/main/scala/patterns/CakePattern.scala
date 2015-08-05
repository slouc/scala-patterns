package patterns

trait FooAble {
  def foo(): String
}

trait MyFooAble extends FooAble {
  def foo() = "here is your foo"
}

trait BarAble {
  def bar(): String
}

trait MyBarAble extends BarAble {
  def bar() = "here is your bar"
}

class Service {
  this: FooAble with BarAble => // any number of injections is possible
  def get() = foo() + ", and " + bar()
}

object CakeMain extends App {

  // service must be provided with impls of FooAble and BarAble
  val service = new Service with MyFooAble with MyBarAble
  
  println(service.get())
  
}
