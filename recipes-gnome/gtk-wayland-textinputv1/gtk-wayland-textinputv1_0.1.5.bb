LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

SRC_URI = " \
    git://gitlab.com/clear-code/gtk-wayland-textinputv1.git;protocol=https \
    file://0001-Search-RECIPE_SYSROOT-to-find-wayland-protocols-if-i.patch \
"

PV = "0.1.5"
SRCREV = "d47a7f47ba56f415fec0fa101a9a01c313acdff0"

S = "${WORKDIR}/git"

DEPENDS = "wayland wayland-native gtk+3"

inherit pkgconfig autotools gtk-immodules-cache

EXTRA_OECONF = "WAYLAND_PROTOCOLS_SYSROOT_DIR=${RECIPE_SYSROOT}"

FILES_${PN} += "\
    ${libdir}/gtk-3.0/3.0.0/immodules/im-wltextinputv1.so \
"
