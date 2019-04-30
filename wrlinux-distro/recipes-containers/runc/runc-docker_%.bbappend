FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://docker-17.03.2-ce.tgz \
"

do_install_append() {
    install -m 755 ${WORKDIR}/docker/docker-runc ${D}${bindir}/runc
}

INSANE_SKIP_${PN} = "already-stripped"
