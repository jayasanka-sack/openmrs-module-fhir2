/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.dao;

import javax.annotation.Nonnull;

import java.util.List;

import org.openmrs.Location;
import org.openmrs.LocationAttribute;
import org.openmrs.LocationAttributeType;
import org.openmrs.LocationTag;
import org.openmrs.annotation.Authorized;
import org.openmrs.module.fhir2.api.search.param.SearchParameterMap;
import org.openmrs.util.PrivilegeConstants;

public interface FhirLocationDao extends FhirDao<Location> {
	
	@Override
	@Authorized(PrivilegeConstants.GET_LOCATIONS)
	Location get(@Nonnull String uuid);
	
	@Authorized(PrivilegeConstants.GET_LOCATIONS)
	List<LocationAttribute> getActiveAttributesByLocationAndAttributeTypeUuid(@Nonnull Location location,
	        @Nonnull String locationAttributeTypeUuid);
	
	@Override
	@Authorized(PrivilegeConstants.MANAGE_LOCATIONS)
	Location createOrUpdate(@Nonnull Location newEntry);
	
	@Override
	@Authorized(PrivilegeConstants.MANAGE_LOCATIONS)
	Location delete(@Nonnull String uuid);
	
	@Override
	@Authorized(PrivilegeConstants.GET_LOCATIONS)
	List<Integer> getSearchResultIds(@Nonnull SearchParameterMap theParams);
	
	@Override
	@Authorized(PrivilegeConstants.GET_LOCATIONS)
	List<Location> getSearchResults(@Nonnull SearchParameterMap theParams, @Nonnull List<Integer> resourceIds);
	
	@Authorized({ PrivilegeConstants.GET_LOCATIONS })
	LocationTag getLocationTagByName(@Nonnull String tag);
	
	@Authorized({ PrivilegeConstants.MANAGE_LOCATION_TAGS })
	LocationTag saveLocationTag(@Nonnull LocationTag tag);
	
	@Authorized({ PrivilegeConstants.GET_LOCATIONS })
	LocationAttributeType getLocationAttributeTypeByUuid(@Nonnull String uuid);
}
