LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6306e547e5c5e43190193019ed46ee13"

DEPENDS = "fcitx anthy fcitx-tools-native qtbase-native"
RDPENDS = "fcitx-bin fcitx-data fcitx-modules"

SRC_URI = "https://gitlab.com/fcitx/fcitx-qt5/-/archive/${PV}/fcitx-qt5-${PV}.tar.bz2"
SRC_URI[md5sum] = "550a0f6215c75a7338ddeef30b3ef245"
SRC_URI[sha256sum] = "741904439c4a7461c5b19b6e9fcdf1446c440ed10c2171f8325ec0ceaff0a65c"

S = "${WORKDIR}/${PN}-${PV}/"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DFCITX_TOOL_BINARY_DIR=${RECIPE_SYSROOT_NATIVE}/${libdir}/fcitx/ \
    -DCMAKE_INSTALL_QTPLUGINDIR=${libdir}/qt5/plugins/ \
"

FILES_${PN} += "${libdir}/qt5/plugins/platforminputcontexts/libfcitxplatforminputcontextplugin.so \
    ${libdir}/fcitx/libexec/fcitx-qt5-gui-wrapper \
    ${libdir}/fcitx/qt/libfcitx-quickphrase-editor5.so \
"

FILES_${PN}-dev += "${libdir}/cmake/FcitxQt5WidgetsAddons \
    ${libdir}/cmake/FcitxQt5DBusAddons \
"
