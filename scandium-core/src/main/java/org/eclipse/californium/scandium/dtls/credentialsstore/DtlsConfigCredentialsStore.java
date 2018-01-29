package org.eclipse.californium.scandium.dtls.credentialsstore;

import java.net.InetSocketAddress;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.pskstore.PskStore;
import org.eclipse.californium.scandium.dtls.rpkstore.TrustedRpkStore;

public class DtlsConfigCredentialsStore implements CredentialsStore{

	private CredentialsConfiguration config;
	
	
	public DtlsConfigCredentialsStore(final DtlsConnectorConfig dtlsConnectorConfig) {
		this.config = new CredentialsConfiguration() {
			
			@Override
			public Boolean isSendRawKey() {
				return dtlsConnectorConfig.isSendRawKey();
			}
			
			@Override
			public X509Certificate[] getTrusts() {
				return dtlsConnectorConfig.getTrustStore();
			}
			
			@Override
			public CipherSuite[] getSupportedCipherSuites() {
				return dtlsConnectorConfig.getSupportedCipherSuites();
			}
			
			@Override
			public TrustedRpkStore getRpkTrustStore() {
				return dtlsConnectorConfig.getRpkTrustStore();
			}
			
			@Override
			public PublicKey getPublicKey() {
				return dtlsConnectorConfig.getPublicKey();
			}
			
			@Override
			public PskStore getPskStore() {
				return dtlsConnectorConfig.getPskStore();
			}
			
			@Override
			public PrivateKey getPrivateKey() {
				return dtlsConnectorConfig.getPrivateKey();
			}
			
			@Override
			public X509Certificate[] getCertificateChain() {
				return dtlsConnectorConfig.getCertificateChain();
			}
		};
	}
	
	@Override
	public CredentialsConfiguration getCredentialsConfiguration(InetSocketAddress inetAddress) {
		return config;
	}
}
