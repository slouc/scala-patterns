package patterns.selflesstrait

trait MySelflessService {
  def foo = 42
}

/**
 * Note that MySelflessService can now be both mixed in and composed:
 *
 * {{{
 * object MixinExample extends MySelflessService {
 *   foo()
 * }
 * }}}
 *
 * {{{
 * import MySelflessService._
 *
 * object ImportExample {
 *   foo()
 * }
 * }}}
 */
object MySelflessService extends MySelflessService

/**
 * Example client for our service
 */
class MyClient {
  val service: MySelflessService = MySelflessService
}

/** 
 *  Another implementation of MySelflessService
 */
trait MyOtherService extends MySelflessService { /* some code */ }
object MyOtherService extends MyOtherService

/** 
 * Example of usage
 */
object SelflessTraitMain extends App {
  
  def mock[Any]: MySelflessService = ???

  // easy to use in tests: 
  val mockService = mock[MySelflessService]

  // service is injected into MyClient
  val client = new MyClient { override val service = mockService }

  // if another implementation is needed....
  val client2 = new MyClient { override val service = MyOtherService }

}
