#
# Copyright (C) 2012-2013 Wind River Systems Inc.
#
# This package matches a FEATURE_PACKAGES_packagegroup-wr-lsbtest definition in
# wrlinux-image.bbclass that may be used to customize an image by
# adding "wr-lsbtest" to IMAGE_FEATURES.
#

# NOTE: These are packages required for running the LSB test, not for
# complying with the LSB

DESCRIPTION = "Wind River Linux core package group: lsbtest"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} = " \
    localedef \
    lsb \
    lsbtest \
    eglibc-utils \
    "
