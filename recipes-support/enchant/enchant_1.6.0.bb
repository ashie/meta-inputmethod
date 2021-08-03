LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=dfcbabf9131dc9a95febef6753a2958b \
                    file://src/myspell/license.myspell;md5=144d202f24e14f38b722f11f45135c91 \
                    file://src/myspell/license.readme;md5=144d202f24e14f38b722f11f45135c91 \
                    file://src/myspell/license.hunspell;md5=6dfc201603e2bf40d3922f326a4e0155"

SRC_URI = "http://www.abisource.com/downloads/enchant/${PV}/enchant-${PV}.tar.gz"
SRC_URI[md5sum] = "de11011aff801dc61042828041fb59c7"
SRC_URI[sha256sum] = "2fac9e7be7e9424b2c5570d8affe568db39f7572c10ed48d4e13cddf03f7097f"

# NOTE: the following prog dependencies are unknown, ignoring: aspell
# NOTE: unable to map the following pkg-config dependencies: libuspell hunspell
#       (this is based on recipes that have previously been built and packaged)
# NOTE: the following library dependencies are unknown, ignoring: hspell aspell voikko
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "glib-2.0"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
# NOTE: spec file indicates the license may be "LGPL"
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-uspell \
                --disable-voikko \
"




