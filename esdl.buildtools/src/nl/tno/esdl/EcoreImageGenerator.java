package nl.tno.esdl;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

public class EcoreImageGenerator implements IWorkflowComponent {

	private static Logger log = Logger.getLogger(EcoreImageGenerator.class);
	private String airdFile;
	private String imageFileName;
	private ResourceSet resourceSet;
	

	@Override
	public void preInvoke() {
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		/*
		try {
			
			//Platform.get
			
			EcorePlugin.ExtensionProcessor.process(null);
			resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(false));
			String s = Messages.AbstractCommandFactory_refreshTasklabel;
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aird", new AirDResourceFactory());
			NoUICallback noUICallback = new NoUICallback();
//			CommonPlugin emfPlugin = CommonPlugin.INSTANCE;
//			
//			SiriusPlugin siriusPlugin = new SiriusPlugin();
//			Implementation implementation = new SiriusPlugin.Implementation();
//			//log.debug(siriusPlugin.getSymbolicName());
//			log.info(implementation.getBundle());;
//			SiriusPlugin.getDefault().setUiCallback(noUICallback);
			
			
			log.info("Exporting image of " + getAirdFile() + " file to " + getImageFileName());
			IProgressMonitor progressMonitor = BasicMonitor.toIProgressMonitor(new LoggerMonitor(log));
			//NullProgressMonitor progressMonitor = new NullProgressMonitor();
			// Get session from an absolute path (not in a workspace)
			URI sessionResourceURI = URI.createFileURI(getAirdFile());
			//Session session = SessionFactory.INSTANCE.createSession(sessionResourceURI, progressMonitor);
			Session session = SessionManager.INSTANCE.openSession(sessionResourceURI, progressMonitor, noUICallback, false);
			session.open(progressMonitor);
			
			
			// Get the expected representation (here the first of the first DView)
			//DAnalysis root = session.getSessionResource().getContents().get(0);
			//DView dView = root.getOwnedViews().get(0);
			//DRepresentation myRepresentation = dView.getOwnedRepresentations().get(0);
			DViewQuery query = new DViewQuery(session.getOwnedViews().iterator().next());
			DRepresentation representation = query.getLoadedRepresentations().get(0);
			
			
			// Export it as PNG image
			ExportFormat exportFormat = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
			DialectUIManager.INSTANCE.export(representation, session, new Path(getImageFileName()), exportFormat,
					progressMonitor);
		} catch (CoreException e) {
			log.error(e);
			e.printStackTrace();

		}
		*/
	}

	@Override
	public void postInvoke() {
	}

	public String getAirdFile() {
		return airdFile;
	}

	public void setAirdFile(String airdFile) {
		this.airdFile = airdFile;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

}
