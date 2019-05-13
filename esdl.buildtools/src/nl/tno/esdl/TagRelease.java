package nl.tno.esdl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;


/**
 * Replaces the Version: $Version$ text in esdl.ecore with the current tag of the git repo by using <tt>git describe --tags</tt>
 * @author werkmane
 *
 */
public class TagRelease implements IWorkflowComponent {

	
	private static Logger log = Logger.getLogger(TagRelease.class);
	private String rootPath;
	private String modelFileName;
	private String esdlParentPomFileName;
	
	@Override
	public void preInvoke() {
	}
	
	@Override
	public void invoke(IWorkflowContext ctx) {
		
		log.info("RootPath = " + rootPath);
		
		try {
			Path absolutePath = Paths.get( Paths.get("").toAbsolutePath().toString(), rootPath ).toRealPath();
			log.info("Absolute Path of ESDL = " + absolutePath);
			String tag = Git.open(absolutePath.toFile()).describe().setTags(true).call();
			log.info("Repo is currently tagged with " + tag);
	        Path path = Paths.get(absolutePath.toString(), getModelFileName());
	        Stream <String> lines = Files.lines(path);
	        List <String> replaced = lines.map(line -> line.replaceAll("(ESDL version: )(.*)(&#xD;&#xA)", "$1" + tag + "$3")).collect(Collectors.toList());
	        Files.write(path, replaced);
	        lines.close();
	        log.info("Set " + getModelFileName() + " version to " + tag);
	        
	        if (esdlParentPomFileName != null) {
		        Path parentPom = Paths.get(absolutePath.toString(), getEsdlParentPomFileName());
		        Stream <String> parentPomLines = Files.lines(parentPom);
		        // <esdl.version>v190513</esdl.version>
		        List <String> replacedLines = parentPomLines.map(line -> line.replaceAll("(<esdl.version>)(.*)(</esdl.version>)", "$1" + tag + "$3")).collect(Collectors.toList());
		        Files.write(parentPom, replacedLines);
		        parentPomLines.close();
		        log.info("Set property esdl.version of " + getEsdlParentPomFileName() + " to " + tag);
	        	
	        }
		} catch (IOException | GitAPIException e) {
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

	public String getModelFileName() {
		return modelFileName;
	}

	@Mandatory
	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

	public String getEsdlParentPomFileName() {
		return esdlParentPomFileName;
	}

	public void setEsdlParentPomFileName(String esdlParentPomFileName) {
		this.esdlParentPomFileName = esdlParentPomFileName;
	} 
	
	

}
