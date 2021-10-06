LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

SRC_URI = "git://gitlab.com/clear-code/gtk-wayland-textinputv1.git;protocol=https"

PV = "0.1.2"
SRCREV = "b0992983e8f76594472e39203bc53d411d16155c"

S = "${WORKDIR}/git"

DEPENDS = "wayland wayland-native gtk+3"

inherit pkgconfig autotools gtk-immodules-cache

EXTRA_OECONF = ""

FILES_${PN} += "\
    ${libdir}/gtk-3.0/3.0.0/immodules/im-wltextinputv1.so \
"
