package com.bk.scalatest.aws.fetchers

import com.bk.scalatest.aws.model.SecurityGroup

object securitygroups {

  def aSecurityGroup(name: String) : Option[SecurityGroup] = {
    Some(SecurityGroup(name))
  }

}
