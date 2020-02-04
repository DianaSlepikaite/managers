/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.kubernetes.internal.properties;

import dev.galasa.framework.spi.ConfigurationPropertyStoreException;
import dev.galasa.framework.spi.cps.CpsProperties;
import dev.galasa.kubernetes.KubernetesManagerException;
import dev.galasa.kubernetes.internal.KubernetesClusterImpl;


/**
 * Kubernetes Override Storage Class CPS Property
 * 
 * @galasa.cps.property
 * 
 * @galasa.name kubernetes.cluster.[XXXX.]override.storageclass
 * 
 * @galasa.description Provides a Kubernetes StorageClass that will be set on all PersistentVolumeClaims
 * that are created in the Kubernetes namespace.   The value of this property is set in the property spec.storageClassName
 * 
 * @galasa.required No
 * 
 * @galasa.default None
 * 
 * @galasa.valid_values A valid StorageClass that is defined in the Kubernetes Cluster
 * 
 * @galasa.examples 
 * <code>kubernetes.cluster.K8S.override.storageclass=fast<br>
 * kubernetes.cluster.override.storageclass=slow</code>
 * 
 */
public class KubernetesStorageClass extends CpsProperties {

    public static String get(KubernetesClusterImpl cluster) throws KubernetesManagerException {
        try {
            return getStringNulled(KubernetesPropertiesSingleton.cps(), "cluster", "override.storageclass", cluster.getId()) ;
        } catch (ConfigurationPropertyStoreException e) {
            throw new KubernetesManagerException("Problem retrieving the storageclass override for cluster " + cluster.getId(), e);
        }
    }
}