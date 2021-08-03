# Recipe created by recipetool
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI = "https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/libhangul/libhangul-${PV}.tar.gz" 
SRC_URI[md5sum] = "e9cf109772cc5fbc79f5de503ea7550a"
SRC_URI[sha256sum] = "5905aa5c557d8d46e190fec1afdd75babf3bc086ef286b42007572703658295a"

inherit autotools-brokensep pkgconfig gettext

