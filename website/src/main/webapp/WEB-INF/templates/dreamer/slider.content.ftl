<div id="jssor_1" style="z-index:100;position: fixed; margin: 0 auto; top: 80px; left: 50px; width: 1200px; height: 800px; overflow: hidden; visibility: hidden;">
    <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 1200px; height: 800px; overflow: hidden;">
        <div data-p="225.00" style="display: none;">
            <img data-u="image" src="${descriptionVo.defaultItem.imageUrl!}" alt="${descriptionVo.defaultItem.content!}"/>

            <div style="position: absolute; bottom: 120px; left: 80px; width: 600px; height: 120px; font-size: 16px; color: #ffffff; line-height: 16px;">
                ${descriptionVo.info.head!}
            </div>
        </div>
        <#list descriptionVo.items as item>
            <div data-p="225.00" style="display: none;">
                <img data-u="image" src="${item.imageUrl!}" alt="${item.content!}"/>

                <div style="position: absolute; bottom: 60px; right: 80px; width: 60%; height: 120px; font-size: 16px; color: #ffffff; line-height: 16px;">
                    ${item.content!}
                </div>
            </div>
        </#list>
    </div>
    <!-- Bullet Navigator -->
    <div data-u="navigator" class="jssorb05" style="bottom:16px;right:6px;" data-autocenter="1">
        <!-- bullet navigator item prototype -->
        <div data-u="prototype" style="width:16px;height:16px;"></div>
    </div>
    <!-- Arrow Navigator -->
    <span data-u="arrowleft" class="jssora22l" style="top:123px;left:12px;width:40px;height:58px;" data-autocenter="2"></span>
    <span data-u="arrowright" class="jssora22r" style="top:123px;right:12px;width:40px;height:58px;" data-autocenter="2"></span>
</div>