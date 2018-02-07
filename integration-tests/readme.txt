This might also work, but is untested.
A colleague came up with this solution for the problem.
This approach sets the categories in properties instead of just setting properties to true/false.
Note that another category interface (NoneExclusion) is needed to switch off all tests. 

<profiles>
	<profile>
		<id>unit-tests</id>
		<activation>
			<activeByDefault>true</activeByDefault>
		</activation>
		<properties>
			<testcase.groups></testcase.groups>
			<testcase.excludedgroups>com.commerzbank.risk.ap.server.integration.IntegrationTest</testcase.excludedgroups>
		 </properties>
	</profile>
	<profile>
		<id>integration-tests</id>
		<properties>
			<testcase.groups>com.commerzbank.risk.ap.server.integration.IntegrationTest</testcase.groups>
			<testcase.excludedgroups></testcase.excludedgroups>
		</properties>
	</profile>
	<profile>
		<id>all-tests</id>
		<properties>
			<testcase.groups></testcase.groups>
			<testcase.excludedgroups></testcase.excludedgroups>
		</properties>
	</profile>
	<profile>
		<id>no-tests</id>
		<properties>
			<!-- Using a Dummy interface which is not used by any junit category will make sure no tests are running! -->
			<testcase.groups>com.commerzbank.risk.ap.server.integration.NoneExclusion</testcase.groups>
			<testcase.excludedgroups></testcase.excludedgroups>
		</properties>
	</profile>
</profiles>

<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>2.13</version>
	<dependencies>
		<dependency>
			<groupId>org.apache.maven.surefire</groupId>
			<artifactId>surefire-junit47</artifactId>
			<version>2.13</version>
		</dependency>
	</dependencies>
	<configuration>
		<groups>${testcase.groups}</groups>
		<includes>
			<include>**/**.java</include>
		</includes>
		<excludedGroups>${testcase.excludedgroups}</excludedGroups>
   </configuration>
</plugin>
