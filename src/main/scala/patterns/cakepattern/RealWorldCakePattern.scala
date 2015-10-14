package patterns.cakepattern

trait ServiceFoo {
  val serviceFoo: ServiceFooImpl
  class ServiceFooImpl {
    def foo() = "here is your foo"
  }
}

trait ServiceBar {
  val serviceBar: ServiceBarImpl
  class ServiceBarImpl {
    def bar() = "here is your bar"
  }
}

class MyService {
  this: ServiceFoo with ServiceBar => // any number of injections is possible
  def get() = serviceFoo.foo() + ", and " + serviceBar.bar()
}

object RealCakeMain extends App {

  // service must be provided with impls of serviceFoo and serviceBar
  val service = new MyService with ServiceFoo with ServiceBar {
    override val serviceFoo = new ServiceFooImpl() // or any other impl
    override val serviceBar = new ServiceBarImpl() // or any other impl
  }

  println(service.get())

}
