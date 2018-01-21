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
  val inputList = List(clientComm, clientComm1)
  val totalComm = new TotalCommission[ClientSideCommission](inputList)
  log.info(s"${totalComm.getTotalCommission}\n")
  val streetComm = StreetSideCommission(commValue3)
  val streetComm1 = StreetSideCommission(commValue4)
  val inputList1 = List(streetComm, streetComm1)
  val totalComm1 = new TotalCommission[StreetSideCommission](inputList1)
  log.info(s"${totalComm1.getTotalCommission}\n")

}
