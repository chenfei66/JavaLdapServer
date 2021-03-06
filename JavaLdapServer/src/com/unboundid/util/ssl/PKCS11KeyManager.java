/*
 * Copyright 2008-2014 UnboundID Corp.
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2008-2014 UnboundID Corp.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.util.ssl;



import java.security.KeyStoreException;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import com.unboundid.util.NotMutable;
import com.unboundid.util.ThreadSafety;
import com.unboundid.util.ThreadSafetyLevel;

import static com.unboundid.util.Debug.*;
import static com.unboundid.util.ssl.SSLMessages.*;



/**
 * This class provides an SSL key manager that may be used to retrieve
 * certificates from a PKCS#11 token.
 */
@NotMutable()
@ThreadSafety(level=ThreadSafetyLevel.COMPLETELY_THREADSAFE)
public final class PKCS11KeyManager
       extends WrapperKeyManager
{
  /**
   * The key store type to use to access PKCS#11 tokens.
   */
  private static final String PKCS11_KEY_STORE_TYPE = "PKCS11";



  /**
   * Creates a new instance of this PKCS11 key manager that provides the ability
   * to retrieve certificates from a PKCS#11 token.
   *
   * @param  keyStorePIN       The PIN to use to access the contents of the
   *                           PKCS#11 token.  It may be {@code null} if no PIN
   *                           is required.
   * @param  certificateAlias  The nickname of the certificate that should be
   *                           selected.  It may be {@code null} if any
   *                           acceptable certificate found may be used.
   *
   * @throws  KeyStoreException  If a problem occurs while initializing this key
   *                             manager.
   */
  public PKCS11KeyManager(final char[] keyStorePIN,
                          final String certificateAlias)
         throws KeyStoreException
  {
    super(getKeyManagers(keyStorePIN), certificateAlias);
  }



  /**
   * Retrieves the set of key managers that will be wrapped by this key manager.
   *
   * @param  keyStorePIN  The PIN to use to access the contents of the PKCS#11
   *                      token.  It may be {@code null} if no PIN is required.
   *
   * @return  The set of key managers that will be wrapped by this key manager.
   *
   * @throws  KeyStoreException  If a problem occurs while initializing this key
   *                             manager.
   */
  private static KeyManager[] getKeyManagers(final char[] keyStorePIN)
          throws KeyStoreException
  {
    final KeyStore ks = KeyStore.getInstance(PKCS11_KEY_STORE_TYPE);
    try
    {
      ks.load(null, keyStorePIN);
    }
    catch (Exception e)
    {
      debugException(e);

      throw new KeyStoreException(
           ERR_PKCS11_CANNOT_ACCESS.get(String.valueOf(e)), e);
    }

    try
    {
      final KeyManagerFactory factory = KeyManagerFactory.getInstance(
           KeyManagerFactory.getDefaultAlgorithm());
      factory.init(ks, keyStorePIN);
      return factory.getKeyManagers();
    }
    catch (Exception e)
    {
      debugException(e);

      throw new KeyStoreException(
           ERR_PKCS11_CANNOT_GET_KEY_MANAGERS.get(String.valueOf(e)), e);
    }
  }
}
