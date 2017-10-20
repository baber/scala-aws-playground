package com.bk.scalatest.aws.matchers

import com.bk.scalatest.aws.model.SecurityGroup
import org.scalatest._
import matchers._

trait SecurityGroupMatchers {

  class ExistsMatcher(securityGroup: SecurityGroup) extends Matcher[SecurityGroup] {

    def apply(left: SecurityGroup) = {
      MatchResult(
        "a test ssh group" == left.name,
        "Failed",
        "Failed Again?"
      )
    }
  }


  def name(expectedValue: String) =
    new HavePropertyMatcher[SecurityGroup, String] {
      def apply(securityGroup: SecurityGroup) =
        HavePropertyMatchResult(

          securityGroup.name == expectedValue,
          "name",
          expectedValue,
          securityGroup.name
        )
    }


  def existInAWS(securityGroup: SecurityGroup) = new ExistsMatcher(securityGroup)
}

object SecurityGroupMatchers extends SecurityGroupMatchers
