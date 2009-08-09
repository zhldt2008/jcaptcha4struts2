<#-- 

/*
 * Copyright (C) 2008-2009 Yohan Liyanage. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

 -->
<#-- 

Image Tag Template - Simple
===========================

Author : Yohan Liyanage

-->
<#if parameters.label?exists>
${parameters.label?html}<#rt/>
<#else>
<div>
Image Verification
</div>
</#if>
<div>
<img src="<@s.url action='jcaptcha_image' />"<#rt/>
<#if parameters.width?exists>
 width="${parameters.width?html}"<#rt/>
</#if>
<#if parameters.height?exists>
 height="${parameters.height?html}"<#rt/>
</#if>
/>
</div>
<div>
<@s.textfield name="jCaptchaResponse" />
</div>
