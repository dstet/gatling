package config

import io.gatling.core.Predef._
import scala.util.Random
import io.gatling.core.structure._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object baseHelpers {

  val homeUrl = "localhost"

  val googleFontsIUri = "https://fonts.googleapis.com/css"

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")

  def getRandomChairID = {
    val arr = Array(50, 51, 52)
    print(arr(Random.nextInt(arr.length)) + ", ")
    arr(Random.nextInt(arr.length))

  }

}

