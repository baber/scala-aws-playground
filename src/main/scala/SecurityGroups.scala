import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder
import com.amazonaws.services.ec2.model.{AuthorizeSecurityGroupIngressRequest, CreateSecurityGroupRequest, CreateSecurityGroupResult, IpPermission}

object SecurityGroups {

  import scala.collection.JavaConversions._

  val ec2Client =
    AmazonEC2ClientBuilder.standard()
      .withCredentials(new ProfileCredentialsProvider("terraform"))
      .withRegion("eu-west-2")
      .build()

  def main(args: Array[String]): Unit = {
    createSSHGroup("allow-inbound-ssh")
  }


  def createSSHGroup(name: String) = {

    val request = new CreateSecurityGroupRequest(name, "Allows inbound SSH access on port 22 only")
    ec2Client.createSecurityGroup(request)
    createInboundSSHRule(name)
  }

  def createInboundSSHRule(securityGroup: String) = {
    val ingressRequest = new AuthorizeSecurityGroupIngressRequest()
      .withGroupName(securityGroup)
      .withIpProtocol("tcp")
      .withCidrIp("163.171.33.130/32")
      .withFromPort(22)
      .withToPort(22)

    ec2Client.authorizeSecurityGroupIngress(ingressRequest)
  }


  def createEC2Instance() = {

  }


}
