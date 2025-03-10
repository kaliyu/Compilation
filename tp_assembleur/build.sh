VERSION=4.13.2

gram=gazo.g4
src="*/*.java"

#Vérifier que la librairie antlr est bien présente
path="/home/o22100171@campus.univ-orleans.fr/Bureau/Compilation/tp_assembleur/antlr-"$VERSION"-complete.jar"
if [ -f "$path" ]; then
	echo "antlr4 OK"
else
	echo "téléchargement antlr"
	curl -o $path https://www.antlr.org/download/antlr-$VERSION-complete.jar
fi



te="org.antlr.v4.Tool"

#export CLASSPATH=$CLASSPATH:$path
#generer fichiers java dans le dossier antlr à partir du fichier .g4
java -cp $path -Xmx500M  $te $gram -visitor -o parser

#ajouter le nom du package en en-tête des fichiers générés
sed -i '1s/^/package parser;\n /' parser/*.java

#les compiler
javac -cp $path $src


