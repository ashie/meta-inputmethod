LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5 gtk+ gtk+3 fcitx5-tools-native"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "bb64a6b39c4e1bd3ba1c7b0d0ff53bce434786fe484e7908ed62593896e73d75"

inherit cmake gtk-immodules-cache
GTKIMMODULES_PACKAGES = "fcitx5-gtk"

SRC_URI_append = "\
    file://0001-Enable-to-build-against-older-GLib-2.60.patch \
"

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
    -DENABLE_GTK4_IM_MODULE=OFF \
    -DENABLE_GIR=OFF \
"

DEBIAN_NOAUTONAME_${PN}2 = "1"
DEBIAN_NOAUTONAME_${PN}3 = "1"
PACKAGES =+ "fcitx5-gclient ${PN}2 ${PN}3"

RDEPENDS_${PN}-gtk2 = "fcitx5-gclient"
RDEPENDS_${PN}-gtk3 = "fcitx5-gclient"

FILES_${PN}2 += "\
    ${libdir}/gtk-2.0/2.10.0/immodules/im-fcitx5.so \
"

FILES_${PN}3 += "\
    ${libdir}/gtk-3.0/3.0.0/immodules/im-fcitx5.so \
"

PACKAGE_WRITE_DEPS += "qemu-native"
