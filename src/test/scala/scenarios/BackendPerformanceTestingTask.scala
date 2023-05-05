package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

import scala.language.postfixOps

object BackendPerformanceTestingTask {
  def scnGatlingTask : ScenarioBuilder = {
    scenario("Backend performance testing task")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("1. Open the application") {
          exec(api.main.openTheApplication())
            .pause(2)
        }
          .group ("2. Navigate to \"Tables\" tab") {
            exec(api.main.navigateToTablesTab())
              .pause(2)
          }
          .group("3. Open a table product cart") {
            exec(api.main.openTableProductCart())
              .pause(2)
          }
          .group("4. Add table to Cart") {
            exec(api.main.addTableToCart())
              .pause(2)
          }
          .randomSwitch(
            50.0 -> group("5. 50% of users") {
               exec(api.main.fiftyPersentOfUsersClickChairsTab())
                .pause(3)
                .exec(api.main.fiftyPersentOfUsersOpenRandomChair())
                .pause(6)
                .exec(api.main.fiftyPersentOfUsersAddChairToCart())
            },
            30.0 -> group("6. 30% of all users") {
              exec(api.main.thirtyPersentOfUsersOpenCart())
                .pause(3)
                .exec(api.main.thirtyPersentOfUsersProceedToCheckout())
            }
          )
      )
  }

//  randomSwitch
}
