package patterns

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
 * import Friendly._
 *
 * object ImportExample extends MySelflessService {
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
 *  Alternative implementation of MySelflessService
 */
trait MyOtherService extends MySelflessService { /* some code */ }
object MyOtherService extends MyOtherService

object SelflessTraitMain extends App {

  def mock[Any]: Unit = ???

  // easy to use in tests: 
  val mockService = mock[MySelflessService]

  // service is injected into MyClient
  val client = new MyClient { override val service = mockService }

  // if another implementation is needed....
  val client2 = new MyClient { override val service = MyOtherService }

}