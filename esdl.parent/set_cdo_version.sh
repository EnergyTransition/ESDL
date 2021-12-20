# updates the pom.xml and Manifest.mf files to a cdo version. E.g. 2.21.9 becomes 2.21.9.cdo
mvn build-helper:parse-version org.eclipse.tycho:tycho-versions-plugin:set-version -Dtycho.mode=maven -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}.cdo
