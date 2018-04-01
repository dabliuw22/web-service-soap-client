# SOAP Client

Cliente para servicio web SOAP, aspectos a tener en cuenta:

1. Gradle >= 4.

2. Dependencias en *build.gradle*:
	```
	dependencies {
		compile('org.springframework.boot:spring-boot-starter-web')
		
		compile('org.springframework.ws:spring-ws-core')
	    compile(files(genJaxb.classesDir).builtBy(genJaxb))
	    jaxb 'com.sun.xml.bind:jaxb-xjc:2.1.7'
	    
	    runtime('org.springframework.boot:spring-boot-devtools')
	    
		testCompile('org.springframework.boot:spring-boot-starter-test')
	}
	```
3. Tarea para Jaxb en *build.gradle*:
	```
	task genJaxb {
	    //ext.sourcesDir = '${buildDir}/generated-sources/jaxb'
	    ext.sourcesDir = 'src/main/java'
	    ext.classesDir = '${buildDir}/classes/jaxb'
	    ext.schema = 'http://localhost:8888/ws/autores.wsdl'
	
	    outputs.dir classesDir
	
	    doLast() {
	        project.ant {
	            taskdef name: 'xjc', classname: 'com.sun.tools.xjc.XJCTask',
	                    classpath: configurations.jaxb.asPath
	            mkdir(dir: sourcesDir)
	            mkdir(dir: classesDir)
	
	            xjc(destdir: sourcesDir, schema: schema,
	                    package: 'com.leysoft.ws.autor') {
	                arg(value: '-wsdl')
	                produces(dir: sourcesDir, includes: '**/*.java')
	            }
	
	            javac(destdir: classesDir, source: 1.8, target: 1.8, debug: true,
	                    debugLevel: 'lines,vars,source',
	                    classpath: configurations.jaxb.asPath) {
	                src(path: sourcesDir)
	                include(name: '**/*.java')
	                include(name: '*.java')
	            }
	
	            copy(todir: classesDir) {
	                fileset(dir: sourcesDir, erroronmissingdir: false) {
	                    exclude(name: '**/*.java')
	                }
	            }
	        }
	    }
	}
	```
4. Ejecutar en la terminal en la raiz del proyecto:
	```
	gradle clean build
	```
5. Clonar el proyecto [web-service-soap](https://github.com/dabliuw22/web-service-soap) y correrlo.

6. Correr el cliente y probar en postman.