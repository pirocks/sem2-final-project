import copy



















import sys


def parseMethods(file):
	out = ''
	for line in file:
		if('class' not in line and 'return' not in line and '//' not in line and ('public' in line or 'private' in line or 'static' in line or 'protected' in line)):
			out += line.replace('{','').replace('/*','').replace("\"",'')
			out += '\n'
	return out


def generateUml():
	plantuml = open("output.txt","r")
	newfile = []
	for line in plantuml:
		if( 'RE' not in line and 'ArrayList' not in line and 'Collections' not in line and 'ThreadLocalRandom' not in line and 'Application' not in line and 'FXMLLoader' not in line and 'Parent' not in line and 'Scene' not in line and 'Stage' not in line and 'BigDecimal' not in line and '//' not in line and 'annotation' not in line and 'enum' not in line and 'java' not in line):
			if('class' in line):
				newline = copy.copy(line)
				filename = newline.split('.')[-1][:-1] + '.java'
				newline += '\n{'
				newline += parseMethods(open(filename,'r'))
				newline += '\n}'
				newline = newline.replace(';','')
				newfile.append(newline)
			else:
				newfile.append(line)
	final_out_string = ''
	for item in newfile:
		final_out_string += item
	return final_out_string
	# print newfile	
def generateDot():
	uml = generateUml()
	uml = uml.replace('class','')
	uml = uml.replace('abstract','')
	uml = uml.replace('interface','')
	uml = uml.replace('annotation','')
	uml = uml.replace('{','\n[label=\"')
	uml = uml.replace('}','"];')
	uml = uml.replace('.','_')
	uml = uml.replace('@startuml', 'graph ghvg{')
	uml = uml.replace('@enduml','}')
	uml = uml.replace(')',');')
	uml = uml.replace(')','')
	uml = uml.replace('(','')
	print uml

def main():
	generateDot()
main()