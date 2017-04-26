require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot port for C.H.I.P. boards"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

DEPENDS += "dtc-native"
PROVIDES += "u-boot"

UBOOT_VERSION ?= "2015.07"
PV = "${UBOOT_VERSION}+git${SRCPV}"

SRCREV ?= "854d5fcc641d8d8914c03a69d7172815d5b81a99"
BRANCH ?= "chip/stable"
SRC_URI = "git://github.com/NextThingCo/CHIP-u-boot.git;branch=${BRANCH} \
           file://0001-Add-compiler-gcc6.h.patch;patch=1 \
           file://0001-Fix-tools-build.patch;patch=1"
S = "${WORKDIR}/git"

do_compile_append() {
    install ${B}/spl/${SPL_BINARY} ${B}/${SPL_BINARY}
}

COMPATIBLE_MACHINE = "chip"
