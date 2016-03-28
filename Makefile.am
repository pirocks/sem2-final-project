AUTOMAKE_OPTIONS = foreign
SUBDIRS = src

clean-local:
	find -name "*.class" | xargs rm;\
	printf find -empty;\ 
	find -empty  |grep -v .git | grep -v .c9 | xargs rm -r;
