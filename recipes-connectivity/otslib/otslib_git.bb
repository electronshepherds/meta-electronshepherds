DESCRIPTION = "Bluetooth Object Transfer Service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/electronshepherds/otslib.git;protocol=ssh;branch=main \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "bluez5 gattlib "
RDEPENDS:${PN} += "bluez5 gattlib "

inherit pkgconfig cmake

PACKAGECONFIG[examples] = "-DOTSLIB_EXAMPLES=YES, -DOTSLIB_EXAMPLES=NO"
PACKAGECONFIG[address-sanitizer] = "-DOTSLIB_ADDRESS_SANITIZER=YES, -DOTSLIB_ADDRESS_SANITIZER=NO, gcc-sanitizers, libasan"

FILES:${PN} = "${libdir}/* ${datadir}/*"
FILES:${PN}-dev = "${includedir}/* ${libdir}/pkgconfig"

EXTRA_OECMAKE ?= ""
