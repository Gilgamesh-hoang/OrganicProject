/**
 * This is main script file that contains JS code.
 */

/*============================================================================*/
/* Place any jQuery/helper plugins in here.
/*============================================================================*/
/**
 * The below expression is a jQuery function call:
 * $(...);
 * Which is the "jQuery function". $ is a function, and $(...) is you calling
 * that function. The first parameter we've supplied is the following
 * `function() {}`. The parameter is a function that you specific, and the '$'
 * function will call the supplied method when the DOM finishing loading.
 * $(function() { ... }) is also jQuery short-hand for
 * $(document).ready(function() { ... });
 */
$(function () {

    // Initialize NProgress
    NProgress.configure({ showSpinner: false });
    // Bind Scroll Up plugin to all pages
    $.scrollUp({
        scrollName: 'topScroll',
        scrollText: '<i class="fas fa-long-arrow-alt-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade',
        zIndex: 100,
    });

    // Bind this plugin on Product `Detail` page
    $('#zoom-pro').elevateZoom({
        gallery: 'gallery',
        galleryActiveClass: 'active',
        borderSize: 1,
        zoomWindowWidth: 540,
        zoomWindowHeight: 540,
        zoomWindowOffetx: 10,
        borderColour: '#e9e9e9',
    });

    // For `modals` we don't want to enable `zoom window`.
    $('#zoom-pro-quick-view').elevateZoom({
        gallery: 'gallery-quick-view',
        galleryActiveClass: 'active',
        zoomEnabled: false, // false disables zoomwindow from showing
    });

    // Bind resize select on mid header
    $('#select-category', document).ResizeSelect();
    $('.select-hide').removeClass('select-hide');

    // Bind mega menu plugin
    $('.v-menu', document).MegaMenuDropDowns();

    // Bind Countdown Timer to all sections
    $('.section-timing-wrapper.dynamic', document).CountDown();
});
/*============================================================================*/
/* Global JavaScript functions
/*============================================================================*/
(function ($, window, document) {
    'use strict';
    // ------------- Variables for Reusability and Performance ---------------
    // Performance of jQuery selectors vs local variables
    // https://jsperf.com/caching-jquery-selectors
    let $vMenu = $('.v-menu');
    let mode = '';
    let bigScreenFlag = Number.MAX_VALUE;
    let smallScreenFlag = 1;
    // ------------------------Back Drop Arena ---------------------------
    let listItembackDropFlag = false;
    let $backDrop;
    let $searchFormWrapper;
    let $searchFormElement;
    let $allListItemsForHover = $('.js-backdrop');
    // ------------------------Back Drop Arena End ---------------------------
    // Object Settings
    let settings = {
        bodyBackDropOnScenes: true,
        zIndexNumber: 999998
    };

    /**
     * return the window's width
     * @return {Number|number}
     */
    const windowWidth = function () {
        return window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    };

    /**
     * @param {jquery} element  - display back drop
     */
    const showBackDrop = function (element) {
        element.css('display', 'block').on('click', function () {
            $(this).css('display', '');
        });
    };

    /**
     * @param {jquery} element  - remove back drop
     */
    const removeBackDrop = function (element) {
        element.css('display', '');
    };

    /**
     * Attach Click Event on Search Button
     */
    const attachClickOnResponsiveSearchForm = function () {
        $('#responsive-search').on('click', function () {
            $('.responsive-search-wrapper').stop(true, true).fadeIn();
        });

        $('#responsive-search-close-button').on('click', function () {
            $('.responsive-search-wrapper').stop(true, true).fadeOut();
        });
    };

    /**
     * Attach Click Event on Mini Cart Anchor
     */
    const attachClickOnMiniCart = function () {
        //  let $href = $('#mini-cart-trigger'.attr('href');
        //   window.location.href = $href; //causes the browser to refresh and
        // load the requested url
        $('#mini-cart-trigger').on('click', function () {
            $('.mini-cart-wrapper').addClass('mini-cart-open');
        });

        $('#mini-cart-close').on('click', function () {
            $('.mini-cart-wrapper').removeClass('mini-cart-open');
        });
    };

    /**
     * Attach Click Event on VMenu
     */
    const attachClickOnVMenu = function () {
        $('.v-title').on('click', function () {
            $vMenu.toggleClass('v-close');
        });
    };

    /**
     * Its a function that is bind to Mega Menu List items with event mouseenter
     */
    const MouseEnterFunctionForMegaMenu = function () {
        // I also Hope elements are appropriate assign
        $vMenu.css({'z-index': settings.zIndexNumber});
        // Show Back Drop
        showBackDrop($backDrop);
    };
    /**
     * Its a function that is bind to Mega Menu List items with event mouseleave
     */
    const MouseLeaveFunctionForMegaMenu = function () {
        // I also Hope elements are appropriate assign
        $vMenu.css({'z-index': ''});
        // Remove Back Drop
        removeBackDrop($backDrop);
    };

    /**
     * Hover on list items that have class `js-backdrop`
     */
    const hoverOnListItems = function () {
        $allListItemsForHover.on('mouseenter', MouseEnterFunctionForMegaMenu);
        $allListItemsForHover.on('mouseleave', MouseLeaveFunctionForMegaMenu);
    };
    /**
     * Hoveroff on list items that have class `js-backdrop`
     */
    const hoverOffListItems = function () {
        $allListItemsForHover.off('mouseenter');
        $allListItemsForHover.off('mouseleave');
    };

    /**
     * Backdrop only works on landscape mode this function will Check
     * if user wants to show or hide the backdrop
     */
    const mainBackDropManipulator = function () {
        if (settings.bodyBackDropOnScenes) {
            if (mode === 'landscape' && !listItembackDropFlag) {
                // If body has length equal to zero then it means our element is
                // not added, if it did'nt have length equal to zero then it
                // means our element is added.
                if ($('#app').find('.body-backdrop').length === 0) {
                    $('#app').append('<div class="body-backdrop"></div>\n');
                    // Assign Back Drop
                    $backDrop = $('div.body-backdrop');
                    // Input type Text
                    $searchFormElement = $('#search-landscape');
                    $searchFormWrapper = $('.form-searchbox');
                    $searchFormElement.focus(function () {
                        // I Hope elements are appropriate assign
                        $searchFormWrapper.css({'position': 'relative', 'z-index': settings.zIndexNumber});
                        // Show Back Drop
                        showBackDrop($backDrop);
                    }).blur(function () {
                        // I Hope elements are appropriate assign
                        $searchFormWrapper.css({'position': '', 'z-index': ''});
                        // Remove Back Drop
                        removeBackDrop($backDrop);
                    });
                    // First Time invocation
                    // HoverOn list items that have class `js-backdrop`
                    hoverOnListItems();
                    // Flag is set to true
                    listItembackDropFlag = true;
                }
            }

            if (mode === 'landscape' && listItembackDropFlag) {
                // It means hover is On
                hoverOnListItems();
            } else if (mode === 'portrait' && listItembackDropFlag) {
                // Hover is Off
                hoverOffListItems();
            }
        }

    };
    /**
     * Manually Restart Pace-js when we change any tab.
     */
    const manuallyRestartProgress = function () {
        // Specificity = 2
        $('a[data-toggle="tab"]').on('shown.bs.tab', function () {
            // Shows the progress bar
            NProgress.start();
            // Completes the progress
            NProgress.done();
        });
    };
    /**
     * Attach Click Event on Quantity buttons
     */
    const attachClickQuantityButton = function () {
        let $currentTextField,currentVal;
        $('.plus-a').each(function () {
            $(this).on('click', function () {
                let $currentTextField = $(this).prev();
                let currentVal = parseInt($currentTextField.val());
                /*
                 * Format values
                 * In JS if variable is not converted to number then by default variable is NaN.
                 * We known JS has Truthy & Falsey values.
                 * By default NaN (e.g. the result of 1/0) is false so its convert to true and expression
                 * becomes true.
                 */
                if (!currentVal || currentVal === '' || currentVal === 'NaN' || currentVal === 0) {
                    // if value is NaN
                    $currentTextField.val(1);
                }
                // Compare and add 1 if the condition is satisfy
                else if (currentVal < $(this).data('max')) {
                    $currentTextField.val(currentVal + 1);
                }
            });
        });
        $('.minus-a').each(function () {
            $(this).on('click', function () {
                $currentTextField = $(this).closest('div').find('input');
                currentVal = parseInt($currentTextField.val());
                /*
                 * Format values
                 * In JS if variable is not convert to number then by default variable is NaN.
                 * We known JS has Truthy & Falsey values.
                 * By default NaN (e.g. the result of 1/0) is false so its convert to true and expression
                 * becomes true.
                 */
                if (!currentVal || currentVal === '' || currentVal === 'NaN' || currentVal === 0) {
                    // if value is NaN
                    $currentTextField.val(1);
                }
                // Compare and minus 1 if the condition is satisfy
                else if (currentVal > $(this).data('min')) {
                    $currentTextField.val(currentVal - 1);
                }
            });
        });
    };

    /**
     * Window Resize Breakpoint Function
     */
    const windowResizeBreakpoint = function () {
        if (windowWidth() <= 991 && bigScreenFlag > 991) {
            // Assign on which mode we are
            mode = 'portrait';
            // Backdrop Manipulator on PORTRAIT
            mainBackDropManipulator();
        }

        if (windowWidth() > 991 && smallScreenFlag <= 991) {
            // Assign on which mode we are
            mode = 'landscape';
            // Backdrop Manipulator on LANDSCAPE
            mainBackDropManipulator();
        }
        bigScreenFlag = windowWidth();
        smallScreenFlag = windowWidth();
    };

    /**
     * Resize event
     */
    $(window).resize(function () {
        // Window Resize Breakpoint Function
        windowResizeBreakpoint();
    });


    /**
     * Only One Time Execution Ready event Check DOM elements if all loaded
     */
    $(function () {
        //  Attach Click Event on Search Button
        attachClickOnResponsiveSearchForm();
        //  Attach Click Event on Mini Cart Anchor
        attachClickOnMiniCart();
        // Attach Click Event on VMenu
        attachClickOnVMenu();
       // Manually Restart Pace-js when we change any tab
        manuallyRestartProgress();
        // Attach Click Event on Quantity buttons
        attachClickQuantityButton();
        // Window Resize Breakpoint Function
        windowResizeBreakpoint();
    });
})(jQuery, window, document);

/*============================================================================*/
/* Homepage JavaScript functions
/*============================================================================*/
(function ($, window, document) {
    'use strict';
    /**
     * Shows Newsletter Modal After 5sec = 5000milliseconds
     */
    const showNewsletterModal = function () {
            setTimeout(function () {
                // Manually opens a modal
                $('#newsletter-modal').modal('show');
            }, 5000);
    };
    /**
     * Initialize Main Slider
     */
    const sliderMain = function () {
        let $owl = $('.slider-main');
        $owl.owlCarousel({
            items: 1,
            autoplay: true,
			autoplayTimeout: 8000,
            loop: false,
            dots: false,
            rewind: true, // Go backwards when the boundary has reached
            nav: true,// Show next/prev buttons
            //   navContainerClass: 'owl-nav' by default,
            navElement: 'div',
            navClass: ['main-slider-previous', 'main-slider-next'],// Add these classes on navElement
            navText: ['<i class="fas fa-angle-left"></i>', '<i class="fas fa-angle-right"></i>'], // by default text prev, next will not show
        });

    };
    /**
     * Initialize owl-carousel for all product-place section on page
     */
    const productSlider = function () {
        // Get Collection of all Product Slider
        let $productsSlider = $('.products-slider');
        $productsSlider.on('initialize.owl.carousel',function () {
           $(this).closest('.slider-fouc').removeAttr('class');
        }).each(function () {
            let thisInstance = $(this);
            let itemPerLine = thisInstance.data('item');
            thisInstance.owlCarousel({
                autoplay: false,
                loop: false,
                dots: false,
                rewind: true,
                nav: true,
                navElement: 'div',
                navClass: ['product-slider-previous', 'product-slider-next'],
                navText: ['<i class="fas fa-angle-left"></i>', '<i class="fas fa-angle-right"></i>'],
                responsive: {
                    0: {
                        items: 1,
                    },
                    768: {
                        items: itemPerLine - 2,
                    },
                    991: {
                        items: itemPerLine - 1,
                    },
                    1200: {
                        items: itemPerLine,
                    },
                }
            });
        });
    };
    /**
     * Initialize owl-carousel for all Specific Category section on page
     */
    const SpecificCategorySlider = function () {
        // Get Collection of all Product Slider
        let $specificCategorySlider = $('.specific-category-slider');
        $specificCategorySlider.on('initialize.owl.carousel',function () {
            $(this).closest('.slider-fouc').removeAttr('class');
        }).each(function () {
            let thisInstance = $(this);
            let itemPerLine = thisInstance.data('item');
            thisInstance.owlCarousel({
                autoplay: false,
                loop: false,
                dots: false,
                rewind: true,
                nav: true,
                navElement: 'div',
                navClass: ['specific-category-slider-previous', 'specific-category-slider-next'],
                navText: ['<i class="fas fa-angle-left"></i>', '<i class="fas fa-angle-right"></i>'],
                responsive: {
                    0: {
                        items: 1,
                    },
                    768: {
                        items: 2,
                    },
                    991: {
                        items: itemPerLine -1,
                    },
                    1200: {
                        items: itemPerLine,
                    },
                }
            });
        });
    };
    /**
     * On Product Slider Tabs: If content is hidden, Owl-carousel refuses to get the dimensions,
     * Sounds like because by default un-active `tab` is set to "display: none"
     * so it can't get the dimensions. Thus we Manually refresh the position on tab change.
     */
    const onTabChangeRefreshPositionOfCarousel = function () {
        // When showing a new tab, the events fire.
        // Specificity = 2
        $('.section-maker [data-toggle="tab"]').on('shown.bs.tab', function (e) {
            // Get the current click id of tab
            let $currentID = $(e.target).attr('href');
            // Trigger refresh `event` to current active `tab`
            $($currentID + '.active').children().trigger('refresh.owl.carousel');
        });

    };
    /**
     * Initialize owl-carousel for brand slider
     */
    const brandSlider = function () {
        let thisInstance = $('.brand-slider-content');
        let itemPerLine = thisInstance.data('item');
        thisInstance.owlCarousel({
            autoplay: true,
			autoplayTimeout: 8000,
            loop: false,
            dots: false,
            rewind: true,
            nav: true,
            navElement: 'div',
            navClass: ['brand-slider-previous', 'brand-slider-next'],
            navText: ['<i class="fas fa-angle-left"></i>', '<i class="fas fa-angle-right"></i>'],
            responsive: {
                0: {
                    items: 1,
                },
                768: {
                    items: 3,
                },
                991: {
                    items: itemPerLine,
                },
                1200: {
                    items: itemPerLine,
                },
            }
        });
    };



    $(function () {
        sliderMain();
        productSlider();
        SpecificCategorySlider();
        onTabChangeRefreshPositionOfCarousel();
        brandSlider();
    });

    /**
     * Check everything including DOM elements and images loaded
     */
    $(window).on('load',function () {
        showNewsletterModal();
       $('.ph-item').removeClass('ph-item');
    });

})(jQuery, window, document);

/*============================================================================*/
/* Contact-page JavaScript functions
/*============================================================================*/
(function ($, window, document) {
    'use strict';
    /**
     * GoogleMap Init
     */
    const googleinitMap = function () {
        // Basic options for a simple Google Map
        // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
        let mapOptions = {
            // How zoomed in you want the map to start at (always required)
            zoom: 11,
            scrollwheel: false,
            // The latitude and longitude to center the map (always required)
            center: new google.maps.LatLng(37.393322, -122.023780),
        };
        // Get the HTML DOM element that will contain your map
        // We are using a div with id="map" seen below in the <body>
        let mapElement = document.getElementById('map');
        // Create the Google Map using our element and options defined above
        let map = new google.maps.Map(mapElement, mapOptions);
        // Let's also add a marker while we're at it
        let marker = new google.maps.Marker({
            position: new google.maps.LatLng(37.393322, -122.023780),
            map: map,
        });
    };


    $(function () {
        // GoogleMap Init
        if ($('#map').length !== 0 ) {
            try {
                google.maps.event.addDomListener(window, 'load', googleinitMap);
            } catch (e) {
                console.log('"Google Maps" refused to connect!');
            }
        }
    });

})(jQuery, window, document);


/*============================================================================*/
/* Product-Detail-page JavaScript functions
/*============================================================================*/
(function ($, window, document) {
    'use strict';
    //  Variables
    let $ratingField = $('#your-rating-value');
    let $starWidth = $('#your-stars');
    let $starComment = $('#star-comment');



    /**
     * Rating Stars Control
     */
    const ratingStarsControl = function () {
        let oneStarWidth = 15; // 15 * 5 = 75
        let newStarWidth;
        let ratingthresholdNumber = 5;
        let comment;
        let currentVal;
        // On Every key type
        $ratingField.on('keyup',function () {
            // Reset Star Width
            $starWidth.css('width',0);
            // Reset Comment
            $starComment.text('');
            // Always remember when when you enter any number and immediately enter some strings then parseFloat
            // function will truncate those strings and just only parse number so that's why i'm using this
            // check isNumeric
            if ($.isNumeric($ratingField.val())) {
                currentVal = parseFloat($ratingField.val());
            } else {
                currentVal = NaN;
            }
            /*
             * Format values
             * In JS if variable is not convert to number then by default variable is NaN.
             * We known JS has Truthy & Falsey values.
             * By default NaN (e.g. the result of 1/0) is false so its convert to true and expression
             * becomes true.
             */
            if ( !currentVal || currentVal === '' || currentVal === 'NaN' || currentVal === 0) {
                // if value is NaN
                currentVal = 0;
                $starWidth.css('width',0);
                $starComment.text('');
            } else {
                if ( (currentVal >=1) && (currentVal <= ratingthresholdNumber)) {

                    if (currentVal === 1 ) {
                        comment = 'I hate it.';
                    }
                    else if(currentVal === 2 ) {
                        comment = "I don't like it.";
                    }
                    else if(currentVal === 3 ) {
                        comment = "It's OK.";
                    }
                    else if(currentVal === 4 ) {
                        comment = "I like it.";
                    }
                    else if(currentVal === 5 ) {
                        comment = "It's Perfect.";
                    }
                    // Precise Float value to only one decimal. example: 2.454544 to 2.5
                    currentVal = currentVal.toFixed(1);
                    // Manipulate Stars Width
                    newStarWidth = oneStarWidth * currentVal;
                    // Remove decimals from a variable, Convert float value to downward
                    newStarWidth = Math.floor(newStarWidth);
                    // Update Star Width
                    $starWidth.css('width',newStarWidth);
                    // Add Comment
                    $starComment.text(comment);
                }
            }
        });

    };



    $(function () {
        // Rating Stars Control
        ratingStarsControl();
    });

})(jQuery, window, document);

/*============================================================================*/
/* Shop-page JavaScript functions
/*============================================================================*/
(function ($, window, document, undefined) {
    'use strict';
    //  Variables
    let $shopProductContainer = $('.product-container');
    let $searchFetchAllbtn = $('.fetch-categories ul > li > button');


    /**
     * Price Range Slider
     */
    const priceRangeSlider = function () {
        $('.price-slider-range').each(function () {
            // Get original minimum data value
            let queryMin = parseFloat($(this).data('min'));
            // Get original maximum data value
            let queryMax = parseFloat($(this).data('max'));
            // Get currency unit
            let currecyUnit = $(this).data('currency');
            // Get default minimum data value
            let defaultLow = parseFloat($(this).data('default-low'));
            // Get default maximum data value
            let defaultHigh = parseFloat($(this).data('default-high'));
            // Taking this
            let $instance = $(this);
            // Plugin invocation
            $('.price-filter').slider({
                range: true,
                min: queryMin,
                max: queryMax,
                values: [ defaultLow, defaultHigh ],
                slide: function (event, ui) {
                    let result = '<div class="price-from">'+ currecyUnit + ui.values[ 0 ] + '</div>\n<div class="price-to">' + currecyUnit + ui.values[ 1 ] + '</div>\n';
                    $instance.parent().find('.amount-result').html(result);
                }
            });


        });
    };
    /**
     * Attach Click event to Grid & List
     */
    const attachClickGridAndList = function () {
        $('#list-anchor').on('click',function () {
            $(this).addClass('active');
            $(this).next().removeClass('active');
            $shopProductContainer.removeClass('grid-style');
            $shopProductContainer.addClass('list-style');
        });
        $('#grid-anchor').on('click',function () {
            $(this).addClass('active');
            $(this).prev().removeClass('active');
            $shopProductContainer.removeClass('list-style');
            $shopProductContainer.addClass('grid-style');
        });
    };
    /**
     * All Categories Functionality
     */
    const searchFetchAllCategoriesFunctionality = function () {
        $searchFetchAllbtn.on('click',function () {
            $(this).toggleClass('js-open');
             $(this).next('ul').stop(true,true).slideToggle();
        });
    };
    /**
     * Bind Slim Scroll Plugin to Associates Filters
     */
    const bindScrollWithAssociateFilters = function () {
        $('.associate-wrapper').each(function () {
            $(this).slimScroll({
                height: 'auto',
                railClass : 'grooverScrollRail',// default CSS class of the slimscroll rail
                barClass : 'grooverScrollBar',// default CSS class of the slimscroll bar
                wrapperClass : 'grooverScrollDiv',// default CSS class of the slimscroll wrapper
            });
        });
    };

    $(function () {
        // Price Range Slider
        priceRangeSlider();
        // Attach Click event to Grid & List
        attachClickGridAndList();
        // Bind Slim Scroll Plugin to Associates Filters
        bindScrollWithAssociateFilters();
        // All Categories Functionality
        searchFetchAllCategoriesFunctionality();
    });

})(jQuery, window, document);


/*app 2*/
(function ($) {
    // Main Object
    var RESHOP = {};

    // Predefined variables
    var
        $filterGridWrapper = $('.filter__grid-wrapper'),
        $collectionOfFilterBtn = $('.filter__btn'),
        $primarySlider = $('#hero-slider'),
        $testimonialSlider = $('#testimonial-slider'),
        $collectionaClickScroll = $('[data-click-scroll]'),
        $collectionProductSlider = $('.product-slider'),
        $collectionTabSlider = $('.tab-slider'),
        $collectionInputCounter = $('.input-counter'),
        $collectionCountDown = $('[data-countdown]'),
        $collectionCartModalLink = $('[data-modal="modal"]'),
        $defaultAddressCheckbox = $('#get-address'),
        $collectionFormBill = $('[data-bill]'),
        $collectionPostGallery = $('.post-gallery'),
        $blogMasonry = $('.blog-m'),
        $collectionPostVideo = $('.post-video-block'),
        // $("iframe[src*="youtube"], iframe[src*="vimeo"]") jQuery Multiple Selector
        $collectionEmbedVideo = $('iframe[src*="youtube"]'),
        $productDetailElement = $('#pd-o-initiate'),
        $productDetailElementThumbnail = $('#pd-o-thumbnail'),
        $modalProductDetailElement = $('#js-product-detail-modal'),
        $modalProductDetailElementThumbnail = $('#js-product-detail-modal-thumbnail'),
        $shopCategoryToggleSpan = $('.shop-w__category-list .has-list > .js-shop-category-span'),// Recursive
        $shopGridBtn = $('.js-shop-grid-target'),
        $shopListBtn = $('.js-shop-list-target'),
        $shopPerspectiveRow = $('.shop-p__collection > div'),
        $shopFilterBtn = $('.js-shop-filter-target');



    // Bind Scroll Up to all pages
    RESHOP.initScrollUp = function() {
        $.scrollUp({
            scrollName: 'topScroll',
            scrollText: '<i class="fa fa-arrow-up"></i>',
            easingType: 'linear',
            scrollSpeed: 900,
            animation: 'fade',
            zIndex: 100
        });
    };

    RESHOP.initScrollSpy = function() {
        var $bodyScrollSpy = $('#js-scrollspy-trigger');
        if ($bodyScrollSpy.length) {
            $bodyScrollSpy.scrollspy({
                target: '#init-scrollspy'
            });
        }
    };

    RESHOP.onClickScroll = function() {
        $collectionaClickScroll.on('click', function (e) {
            // prevent default behavior means page doesn't move or show up id's on browser status-bar
            e.preventDefault();
            // Get Target
            var target = $(this).data('click-scroll');
            // check if anchor has hash
            if ($(target).length) {
                $('html').animate({
                    // .offset() is jQuery function and it returns jQuery object which
                    // has top, left, bottom property and returns total distance from the html container
                    scrollTop: $(target).offset().top
                }, 1000, function () {
                });
            }
        });
    };

    // Bind Tooltip to all pages
    RESHOP.initTooltip = function() {

        $('[data-tooltip="tooltip"]').tooltip({
            // The default value for trigger is 'hover focus',
            // thus the tooltip stay visible after a button is clicked,
            // until another button is clicked, because the button is focused.
            trigger : 'hover'
        });
    };

    // Bind Modals
    RESHOP.initModal = function() {
        // Check if these anchors are on page
        if ($collectionCartModalLink.length) {
            $collectionCartModalLink.on('click',function () {
                var getElemId = $(this).data('modal-id');
                $(getElemId).modal({
                    backdrop: 'static',
                    keyboard: false,
                    show:true
                });


            });
        }

    };

    // Default Billing Address
    RESHOP.defaultAddressCheckbox = function() {
        if ($defaultAddressCheckbox.length) {
            $defaultAddressCheckbox.change(function () {
                if (this.checked) {
                    $collectionFormBill.prop("disabled", true);
                    $('#make-default-address').prop("checked", false);
                } else {
                    $collectionFormBill.prop("disabled", false);
                }
            });

        }
    };





    RESHOP.reshopNavigation = function() {
        $('#navigation').shopNav();
        $('#navigation1').shopNav();
        $('#navigation2').shopNav();
        $('#navigation3').shopNav();
    };

    RESHOP.onTabActiveRefreshSlider = function() {
        // When showing a new tab, the events fire.
        // Specificity = 2
        $('.tab-list [data-toggle="tab"]').on('shown.bs.tab', function (e) {
            // Get the current click id of tab
            var currentID = $(e.target).attr('href');
            // Trigger refresh `event` to current active `tab`
            $(currentID + '.active').find('.tab-slider').trigger('refresh.owl.carousel');
        });
    };

    // Bind all sliders into the page
    RESHOP.primarySlider = function() {
        if ($primarySlider.length) {
            $primarySlider.owlCarousel({
                items: 1,
                autoplayTimeout: 8000,
                loop: true,
                margin: -1,
                dots: false,
                smartSpeed: 1500,
                rewind: false, // Go backwards when the boundary has reached
                nav: false,
                responsive: {
                    992: {
                        dots: true
                    }
                }
            });
        }
    };

    // Bind all sliders into the page
    RESHOP.productSlider = function() {
        // 0 is falsy value, 1 is truthy
        if ($collectionProductSlider.length) {
            $collectionProductSlider.on('initialize.owl.carousel', function () {
                $(this).closest('.slider-fouc').removeAttr('class');
            }).each(function () {
                var thisInstance = $(this);
                var itemPerLine = thisInstance.data('item');
                thisInstance.owlCarousel({
                    autoplay: false,
                    loop: false,
                    dots: false,
                    rewind: true,
                    smartSpeed: 1500,
                    nav: true,
                    navElement: 'div',
                    navClass: ['p-prev', 'p-next'],
                    navText: ['<i class="fas fa-long-arrow-alt-left"></i>', '<i class="fas fa-long-arrow-alt-right"></i>'],
                    responsive: {
                        0: {
                            items: 1
                        },
                        768: {
                            items: itemPerLine - 2
                        },
                        991: {
                            items: itemPerLine - 1
                        },
                        1200: {
                            items: itemPerLine
                        }
                    }
                });
            });
        }
    };


    // Bind all sliders into the page
    RESHOP.tabSlider = function() {
        if ($collectionTabSlider.length) {
            $collectionTabSlider.on('initialize.owl.carousel', function () {
                $(this).closest('.slider-fouc').removeAttr('class');
            }).each(function () {
                var thisInstance = $(this);
                var itemPerLine = thisInstance.data('item');
                thisInstance.owlCarousel({
                    autoplay: false,
                    loop: false,
                    dots: false,
                    rewind: true,
                    smartSpeed: 1500,
                    nav: true,
                    navElement: 'div',
                    navClass: ['t-prev', 't-next'],
                    navText: ['<i class="fas fa-long-arrow-alt-left"></i>', '<i class="fas fa-long-arrow-alt-right"></i>'],
                    responsive: {
                        0: {
                            items: 1
                        },
                        768: {
                            items: itemPerLine - 2
                        },
                        991: {
                            items: itemPerLine - 1
                        },
                        1200: {
                            items: itemPerLine
                        }
                    }
                });
            });
        }
    };

    // Bind Brand slider
    RESHOP.brandSlider = function() {
        var $brandSlider = $('#brand-slider');
        // Check if brand slider on the page
        if ($brandSlider.length) {
            var itemPerLine = $brandSlider.data('item');
            $brandSlider.on('initialize.owl.carousel', function () {
                $(this).closest('.slider-fouc').removeAttr('class');
            }).owlCarousel({
                autoplay: false,
                loop: false,
                dots: false,
                rewind: true,
                nav: true,
                navElement: 'div',
                navClass: ['b-prev', 'b-next'],
                navText: ['<i class="fas fa-angle-left"></i>', '<i class="fas fa-angle-right"></i>'],
                responsive: {
                    0: {
                        items: 1
                    },
                    768: {
                        items: 3,
                    },
                    991: {
                        items: itemPerLine
                    },
                    1200: {
                        items: itemPerLine
                    }
                }

            });
        }
    };

    // Testimonial Slider
    RESHOP.testimonialSlider = function() {
        // Check if Testimonial-Slider on the page
        if ($testimonialSlider.length) {
            $testimonialSlider.on('initialize.owl.carousel', function () {
                $(this).closest('.slider-fouc').removeAttr('class');
            }).owlCarousel({
                items:1,
                autoplay: false,
                loop: false,
                dots: true,
                rewind: false,
                smartSpeed: 1500,
                nav: false
            });
        }
    };
    // Remove Class from body element
    RESHOP.appConfiguration = function() {
        $('body').removeAttr('class');
        $('.preloader').removeClass('is-active');
    };

    // Bind isotope filter plugin
    RESHOP.isotopeFilter = function() {

        // Check if filter grid wrapper on the page
        if ($filterGridWrapper.length) {

            $filterGridWrapper.isotope({
                itemSelector:'.filter__item',
                filter: '*'
            });
        }

        // Check if filter buttons are on page then attach click
        if ($collectionOfFilterBtn.length) {
            // Attack click event to these filter buttons
            $collectionOfFilterBtn.on('click',function(){
               // Get Value of the attribute data-filter
               var selectorValue = $(this).attr('data-filter');
               // Now initialize isotope plugin
                $filterGridWrapper.isotope({
                    filter:selectorValue
                });
               $(this).closest('.filter-category-container').find('.js-checked').removeClass('js-checked');
               $(this).addClass('js-checked');
            });
        }
    };

    // Bind countdown plugin
    RESHOP.timerCountDown = function() {
        // Check if Count Down on the page
        if ($collectionCountDown.length) {
            $collectionCountDown.each(function () {
                var $this = $(this),
                    finalDate = $(this).data('countdown');
                $this.countdown(finalDate, function (event) {
                      $this.html(event.strftime('<div class="countdown__content"><div><span class="countdown__value">%D</span><span class="countdown__key">Days</span></div></div><div class="countdown__content"><div><span class="countdown__value">%H</span><span class="countdown__key">Hours</span></div></div><div class="countdown__content"><div><span class="countdown__value">%M</span><span class="countdown__key">Mins</span></div></div><div class="countdown__content"><div><span class="countdown__value">%S</span><span class="countdown__key">Secs</span></div></div>'));
                });
            });
        }

    };

    // Input Counter
    RESHOP.initInputCounter = function() {
        // Check if Input Counters on the page
        if ($collectionInputCounter.length) {
            // Attach Click event to plus button
            $collectionInputCounter.find('.input-counter__plus').on('click',function () {
                var $input = $(this).parent().find('input');
                var count = parseInt($input.val()) + 1; // Number + Number
                $input.val(count).change();
            });
            // Attach Click event to minus button
            $collectionInputCounter.find('.input-counter__minus').on('click',function () {
                var $input = $(this).parent().find('input');
                var count = parseInt($input.val()) - 1; // Number - Number
                $input.val(count).change();
            });
            // Fires when the value of the element is changed
            $collectionInputCounter.find('input').change(function () {
                var $this = $(this);
                var min = $this.data('min');
                var max = $this.data('max');
                var val = parseInt($this.val());// Current value
                // Restrictions check
                if (!val) {
                   val = 1;
                }
                // The min() method returns the number with the lowest value
                val = Math.min(val,max);
                // The max() method returns the number with the highest value
                val = Math.max(val,min);
                // Sets the Value
                $this.val(val);
            });
        }
    };


    // Blog Post Gallery
    RESHOP.blogPostGallery = function() {
        if ($collectionPostGallery.length) {
            $collectionPostGallery.on('initialize.owl.carousel', function () {
                $(this).closest('.slider-fouc').removeAttr('class');
            }).each(function () {
                $(this).owlCarousel({
                    items:1,
                    autoplay: false,
                    loop: false,
                    dots: false,
                    rewind: true,
                    smartSpeed: 1500,
                    nav: true,
                    navElement: 'div',
                    navClass: ['post-prev', 'post-next'],
                    navText: ['<i class="fas fa-long-arrow-alt-left"></i>', '<i class="fas fa-long-arrow-alt-right"></i>'],
                });
            });
        }
    };

    // Blog Post Masonry
    RESHOP.blogPostMasonry = function() {
        if ($blogMasonry.length) {
            $blogMasonry.find('.blog-m-init').isotope({
                itemSelector: '.blog-m__element',
                layoutMode: 'masonry'
            });
        }
    };

    // Blog Post Video
    RESHOP.blogPostVideo = function() {
        if ($collectionPostVideo.length) {
            $collectionPostVideo.on('click',function (e) {
                e.preventDefault();
                var $this = $(this);
                // Find immediate child that has .bp__video class
                var myVideo = $this.find('.post-video')[0];
                // Add ended event
                $(myVideo).on('ended',function () {
                    $this.removeClass('process');// Add play icon
                });
                // By default it is paused
                if (myVideo.paused) {
                    // Play Video
                    myVideo.play();
                    $(this).addClass('process');
                    if ($(this).hasClass('pause')) {
                        $(this).removeClass('pause');
                    }
                } // if user again click that block just pause the video and add icon
                else {
                    myVideo.pause();
                    $(this).addClass('pause');
                }
            });
        }
    };

    // Blog Post Embed Video
    RESHOP.blogPostEmbedVideo = function() {
        if ($collectionEmbedVideo.length) {
            $collectionEmbedVideo.parent().fitVids();
        }
    };




    // Product Detail Init
    RESHOP.productDetailInit = function() {
      if ($productDetailElement.length && $productDetailElementThumbnail.length) {

          var ELEVATE_ZOOM_OBJ = {
              borderSize: 1,
              autoWidth:true,
              zoomWindowWidth: 540,
              zoomWindowHeight: 540,
              zoomWindowOffetx: 10,
              borderColour: '#e9e9e9',
              cursor: 'pointer'
          };
            // Fires after first initialization
          $productDetailElement.on('init', function () {
              $(this).closest('.slider-fouc').removeClass('slider-fouc');
          });

          $productDetailElement.slick({
              slidesToShow: 1,
              slidesToScroll: 1,
              infinite:false,
              arrows: false,
              dots: false,
              fade: true,
              asNavFor: $productDetailElementThumbnail
          });
          // Init elevate zoom plugin to the first image
          $('#pd-o-initiate .slick-current img').elevateZoom(ELEVATE_ZOOM_OBJ);

          // Fires before slide change
          $productDetailElement.on('beforeChange', function(event, slick, currentSlide, nextSlide){
              // Get the next slide image
              var $img = $(slick.$slides[nextSlide]).find('img');
              // Remove old zoom elements
              $('.zoomWindowContainer,.zoomContainer').remove();
              // Reinit elevate zoom plugin to the next slide image
              $($img).elevateZoom(ELEVATE_ZOOM_OBJ);
          });

          // Init Lightgallery plugin
          $productDetailElement.lightGallery({
              selector: '.pd-o-img-wrap',// lightgallery-core
              download: false,// lightgallery-core
              thumbnail: false,// Thumbnails
              autoplayControls: false,// Autoplay-plugin
              actualSize: false,// Zoom-plugin: Enable actual pixel icon
              hash: false, // Hash-plugin
              share: false// share-plugin
          });
          // Thumbnail images
          // Fires after first initialization
          $productDetailElementThumbnail.on('init', function () {
              $(this).closest('.slider-fouc').removeAttr('class');
          });

          $productDetailElementThumbnail.slick({
              slidesToShow: 4,
              slidesToScroll: 1,
              infinite:false,
              arrows: true,
              dots: false,
              focusOnSelect: true,
              asNavFor: $productDetailElement,
              prevArrow:'<div class="pt-prev"><i class="fas fa-angle-left"></i>',
              nextArrow:'<div class="pt-next"><i class="fas fa-angle-right"></i>',
              responsive: [
                  {
                      breakpoint: 1200,
                      settings: {
                          slidesToShow: 4
                      }
                  },
                  {
                      breakpoint: 992,
                      settings: {
                          slidesToShow: 3
                      }
                  },
                  {
                      breakpoint: 576,
                      settings: {
                          slidesToShow: 2
                      }
                  }
              ]
          });
      }
    };

    // Modal Product Detail Init
    RESHOP.modalProductDetailInit = function() {
        if ($modalProductDetailElement.length && $modalProductDetailElementThumbnail.length) {
            $modalProductDetailElement.slick({
                slidesToShow: 1,
                slidesToScroll: 1,
                infinite:false,
                arrows: false,
                dots: false,
                fade: true,
                asNavFor: $modalProductDetailElementThumbnail
            });

            $modalProductDetailElementThumbnail.slick({
                slidesToShow: 4,
                slidesToScroll: 1,
                infinite:false,
                arrows: true,
                dots: false,
                focusOnSelect: true,
                asNavFor: $modalProductDetailElement,
                prevArrow:'<div class="pt-prev"><i class="fas fa-angle-left"></i>',
                nextArrow:'<div class="pt-next"><i class="fas fa-angle-right"></i>',
                responsive: [
                    {
                        breakpoint: 1200,
                        settings: {
                            slidesToShow: 4
                        }
                    },
                    {
                        breakpoint: 992,
                        settings: {
                            slidesToShow: 3
                        }
                    },
                    {
                        breakpoint: 576,
                        settings: {
                            slidesToShow: 2
                        }
                    }
                ]
            });
            // Hook into Bootstrap shown event and manually trigger 'resize' event
            // so that Slick recalculates the widths
            $('#quick-look').on('shown.bs.modal', function () {
                $modalProductDetailElement.resize();
            });
        }
    };
    // Shop Category Toggle Functionality
    RESHOP.shopCategoryToggle = function() {
        if ($shopCategoryToggleSpan.length) {
            $shopCategoryToggleSpan.on('click', function () {
                $(this).toggleClass('is-expanded');
                $(this).next('ul').stop(true, true).slideToggle();
            });
        }
    };



    // Shop Perspective Change
    RESHOP.shopPerspectiveChange = function() {
          if ($shopGridBtn.length && $shopListBtn.length)   {
              $shopGridBtn.on('click',function () {
                  $(this).addClass('is-active');
                  $shopListBtn.removeClass('is-active');
                  $shopPerspectiveRow.removeClass('is-list-active');
                  $shopPerspectiveRow.addClass('is-grid-active');
              });
              $shopListBtn.on('click',function () {
                  $(this).addClass('is-active');
                  $shopGridBtn.removeClass('is-active');
                  $shopPerspectiveRow.removeClass('is-grid-active');
                  $shopPerspectiveRow.addClass('is-list-active');
              });
          }
    };
    // Shop Side Filter Settings
    RESHOP.shopSideFilter = function() {
        if ($shopFilterBtn.length) {
            $shopFilterBtn.on('click',function () {
                // Add Class Active
                $(this).toggleClass('is-active');
                // Get Value of the attribute data-side
                var target = $(this).attr('data-side');
                // Open Side
                $(target).toggleClass('is-open');
            });
        }
    };

    // Show Newsletter Modal
    RESHOP.showNewsletterModal = function() {
        if ($('#newsletter-modal').length) {
            setTimeout(function () {
                // Manually opens a modal
                $('#newsletter-modal').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }, 5000);
        }
    };

    // Check everything including DOM elements and images loaded
    $(window).on('load',function () {
        RESHOP.showNewsletterModal();
        if ($primarySlider.length) {
            // Play slider when everything is loaded
            $primarySlider.data('owl.carousel').options.autoplay = true;
            $primarySlider.trigger('refresh.owl.carousel');
        }
    });


        RESHOP.initScrollUp();
        RESHOP.initTooltip();
        RESHOP.initModal();
        RESHOP.defaultAddressCheckbox();
        RESHOP.initScrollSpy();
        RESHOP.onClickScroll();
        RESHOP.reshopNavigation();
        RESHOP.primarySlider();
        RESHOP.productSlider();
        RESHOP.tabSlider();
        RESHOP.onTabActiveRefreshSlider();
        RESHOP.brandSlider();
        RESHOP.testimonialSlider();
        RESHOP.appConfiguration();
        RESHOP.isotopeFilter();
        RESHOP.timerCountDown();
        RESHOP.initInputCounter();
        RESHOP.blogPostGallery();
        RESHOP.blogPostVideo();
        RESHOP.blogPostEmbedVideo();
        RESHOP.blogPostMasonry();
        RESHOP.productDetailInit();
        RESHOP.modalProductDetailInit();
        RESHOP.shopCategoryToggle();
        RESHOP.shopPerspectiveChange();
        RESHOP.shopSideFilter();
})(jQuery);















