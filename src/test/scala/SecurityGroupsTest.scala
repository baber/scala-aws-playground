import org.scalatest._
import com.bk.scalatest.aws.matchers.SecurityGroupMatchers._
import com.bk.scalatest.aws.fetchers.securitygroups._


class SecurityGroupsTest extends FeatureSpec with Matchers with GivenWhenThen {

  feature("Security Group Creation") {
    scenario("ssh group is created") {

      Given("nothing")

      When("a default ssh group is created")
//      SecurityGroups.createSSHGroup("a test ssh group")

      Then("the group should exist")
      val optionalSecurityGroup = aSecurityGroup("a test ssh group")

      optionalSecurityGroup should not be empty

      val securityGroup = optionalSecurityGroup.get
      securityGroup should have (name("a test ssh group"))
    }
  }

}
