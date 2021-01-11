if [ -z $1 ]; then
	echo "Usage $0 <version>, e.g. 1.21.1"
	exit 0
fi
mvn -Dtycho.mode=maven -DnewVersion=$1 org.eclipse.tycho:tycho-versions-plugin:set-version
