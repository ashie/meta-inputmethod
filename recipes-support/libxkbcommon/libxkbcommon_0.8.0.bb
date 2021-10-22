LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e525ed9809e1f8a07cf4bce8b09e8b87"

SRC_URI = "https://xkbcommon.org/download/libxkbcommon-${PV}.tar.xz"
SRC_URI[md5sum] = "7d0e4c4a137d0ac45bf6b328c84c3a81"
SRC_URI[sha256sum] = "e829265db04e0aebfb0591b6dc3377b64599558167846c3f5ee5c5e53641fe6d"

S = "${WORKDIR}/libxkbcommon-${PV}"

DEPENDS = "bison-native libxcb"

inherit pkgconfig autotools

EXTRA_OECONF = " \
    --without-doxygen \
    --with-default-rules="xorg" \
    --with-x-locale-root=${D}/usr/lib/X11/locale \
    --disable-wayland \
"

BBCLASSEXTEND = "native nativesdk"
