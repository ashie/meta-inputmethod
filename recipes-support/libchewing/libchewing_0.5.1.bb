# Recipe created by recipetool
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "sqlite3 libchewing-tools-native"
RDEPENDS_remove = "libgcc gcc-runtime"
TARGET_LDFLAGS += " -static-libgcc -static-libstdc++ "

SRC_URI = "https://github.com/chewing/libchewing/releases/download/v${PV}/libchewing-${PV}.tar.bz2" 
SRC_URI[md5sum] = "2739d5c5697db2eb1d097b6bfb73bf0c"
SRC_URI[sha256sum] = "9708c63415fa6034435c0f38100e7d30d0e1bac927f67bec6dfeb3fef016172b"

SRC_URI += "file://fix-for-cross-compile.patch"

inherit autotools pkgconfig
