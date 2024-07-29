package habuma.hellok8s;

import io.dekorate.kubernetes.annotation.ConfigMapVolume;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Mount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * DockerBuild "image" forces all 3 levels of identification associated with docker image being used
 * @DockerBuild(image="foo/bar:baz")
 */

@KubernetesApplication(
        /*
         * partOf should be picked up from the pom file but it's not exposed that way.
         * it also is the equivalent this application.property:
         * #dekorate.kubernetes.partOf=RIOZ
         * ...
         * partOf = "RIOZ" ,
        */
        configMapVolumes = @ConfigMapVolume(
                configMapName = "greeting-config",
                volumeName = "greeting-config-volume",
                defaultMode = 0644
        ),
        mounts = @Mount(
                name = "greeting-config-volume",
                path = "/etc/config"
        ),
        envVars = @Env(
                name="SPRING_CONFIG_IMPORT",
                value="configtree:/etc/config/"
        )
)
public class HelloK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloK8sApplication.class, args);
    }

}
