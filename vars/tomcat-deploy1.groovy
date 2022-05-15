def call(tomcatIP,warName,credID"){     
     sshagent([${"credID"}]) {
               sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@${tomcatIP}:/opt/tomcat8/webapps/${warName}.war"
               sh "ssh ec2-user@${tomcatIP} /opt/tomcat8/bin/shutdown.sh"
               sh "ssh ec2-user@&{tomcatIP} /opt/tomcat8/bin/startup.sh"
}
