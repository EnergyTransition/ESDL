package nl.tno.esdl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

public class ESDLDocumentationGenerator implements IWorkflowComponent {

	private String rootPath;
	private String ecoreDocgenYamlFile;
	
	private static Logger log = Logger.getLogger(ESDLDocumentationGenerator.class);

	@Override
	public void preInvoke() {
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		try {
			Path absolutePath = Paths.get( Paths.get("").toAbsolutePath().toString(), rootPath ).toRealPath();
			Path yamlFile = Paths.get(absolutePath.toString(), getEcoreDocgenYamlFile());
			log.info("Ecore-docgen Yaml file at " + yamlFile);
			
			
			
			
			
		} catch (IOException e) {
			log.error(e);
		}

	}

	@Override
	public void postInvoke() {
	}
	
	
	public String getRootPath() {
		return rootPath;
	}

	@Mandatory
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getEcoreDocgenYamlFile() {
		return ecoreDocgenYamlFile;
	}

	@Mandatory
	public void setEcoreDocgenYamlFile(String ecoreDocgenYamlFile) {
		this.ecoreDocgenYamlFile = ecoreDocgenYamlFile;
	}
}
