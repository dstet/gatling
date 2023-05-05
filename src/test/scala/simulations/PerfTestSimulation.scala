package simulations
import config.baseHelpers._
import io.gatling.core.Predef._
import scenarios.BackendPerformanceTestingTask._

// mvn gatling:test

class PerfTestSimulation extends Simulation {
  setUp(
    scnGatlingTask.inject(rampUsers(100).during(60))).protocols(httpProtocol)
}
