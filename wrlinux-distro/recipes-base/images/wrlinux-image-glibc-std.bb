#
# Copyright (C) 2012 Wind River Systems, Inc.
#
DESCRIPTION = "An image which approximates WRLinux glibc-std without graphics."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r5"

IMAGE_INSTALL = " \
    ${@bb.utils.contains('IMAGE_ENABLE_CONTAINER', '1', '', 'kernel-modules', d)} \
    packagegroup-base-extended \
    packagegroup-wr-base \
    packagegroup-wr-base-net \
    packagegroup-wr-base-discrete-tools \
    packagegroup-wr-boot \
    nfs-utils-client \
    "

inherit wrlinux-image

IMAGE_FEATURES += " \
    package-management \
    wr-core-db \
    wr-core-interactive \
    wr-core-net \
    wr-core-perl \
    wr-core-python \
    wr-core-sys-util \
    wr-core-util \
    wr-core-mail \
    wr-bsps \
    "
