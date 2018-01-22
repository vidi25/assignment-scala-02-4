package edu.knoldus

import edu.knoldus.CalculateCommission._
import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val commValue1 = 5
  val commValue2 = 4
  val commValue3 = 1
  val commValue4 = 6
  val clientComm = ClientSideCommission(commValue1)
  val clientComm1 = ClientSideCommission(commValue2)
  val listOfClientCommission = List(clientComm, clientComm1)
  val totalComm = new TotalCommission[ClientSideCommission](listOfClientCommission)
  log.info(s"${totalComm.getTotalCommission}\n")
  val streetComm = StreetSideCommission(commValue3)
  val streetComm1 = StreetSideCommission(commValue4)
  val listOfStreetCommission = List(streetComm, streetComm1)
  val totalComm1 = new TotalCommission[StreetSideCommission](listOfStreetCommission)
  log.info(s"${totalComm1.getTotalCommission}\n")
  val listOfMingledCommission = List(clientComm, streetComm)
  val totalComm2 = new TotalCommission[Commission](listOfMingledCommission)
  log.info(s"${totalComm2.getTotalCommission}")

}
