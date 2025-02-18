#
# Copyright (C) 2012-2013 Wind River Systems Inc.
#
# This package matches a FEATURE_PACKAGES_packagegroup-wr-core-sys-util definition in
# wrlinux-image.bbclass that may be used to customize an image by
# adding "wr-core-sys-util" to IMAGE_FEATURES.
#

DESCRIPTION = "Wind River Linux core package group: sys-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r4"

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} = " \
    util-linux-fsck \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    elfutils \
    hdparm \
    iproute2 \
    iptables \
    iputils \
    iw \
    ldd \
    lsof \
    lvm2 \
    mdadm \
    mtd-utils \
    pam-plugin-wheel \
    quota \
    sdparm \
    setserial \
    strace \
    tcf-agent \
    usbutils \
    watchdog \
    ${@bb.utils.contains('INCOMPATIBLE_LICENSE', 'GPLv3+', '', 'parted', d)} \
    "
RRECOMMENDS_${PN} = " \
    mtd-utils-jffs2 \
    mtd-utils-ubifs \
    mtd-utils-misc \
    "

RDEPENDS_${PN}_append_x86 = " pmtools iasl"
RDEPENDS_${PN}_append_x86-64 = " pmtools iasl"
