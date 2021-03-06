package com.amaze.filemanager.activities;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaze.filemanager.R;
import com.amaze.filemanager.activities.superclasses.BasicActivity;
import com.amaze.filemanager.utils.Utils;
import com.amaze.filemanager.utils.theme.AppTheme;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;

/**
 * Created by vishal on 27/7/16.
 */
public class AboutActivity extends BasicActivity implements View.OnClickListener {

    private static final String TAG = "AboutActivity";

    private static final int HEADER_HEIGHT = 1024;
    private static final int HEADER_WIDTH = 500;

    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private TextView mTitleTextView;
    private int mCount=0;
    private Snackbar snackbar;
    private SharedPreferences mSharedPref;
    private View mAuthorsDivider;

    private static final String KEY_PREF_STUDIO = "studio";
    private static final String URL_AUTHOR_1_G_PLUS = "https://plus.google.com/u/0/110424067388738907251/";
    private static final String URL_AUTHOR_1_PAYPAL = "arpitkh96@gmail.com";
    private static final String URL_AUTHOR_2_G_PLUS = "https://plus.google.com/+VishalNehra/";
    private static final String URL_AUTHOR_2_PAYPAL = "https://www.paypal.me/vishalnehra";
    private static final String URL_DEVELOPER1_GITHUB = "https://github.com/EmmanuelMess";
    private static final String URL_DEVELOPER1_BITCOIN = "bitcoin:12SRnoDQvDD8aoCy1SVSn6KSdhQFvRf955?amount=0.0005";
    private static final String URL_REPO_CHANGELOG = "https://github.com/TeamAmaze/AmazeFileManager/commits/master";
    private static final String URL_REPO_ISSUES = "https://github.com/TeamAmaze/AmazeFileManager/issues";
    private static final String URL_REPO_TRANSLATE = "https://www.transifex.com/amaze/amaze-file-manager-1/";
    private static final String URL_REPO_G_PLUS_COMMUNITY = "https://plus.google.com/communities/113997576965363268101";
    private static final String URL_REPO_XDA = "http://forum.xda-developers.com/android/apps-games/app-amaze-file-managermaterial-theme-t2937314";
    private static final String URL_REPO_RATE = "market://details?id=com.amaze.filemanager";
    private static final String TAG_CLIPBOARD_DONATE = "donate_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getAppTheme().equals(AppTheme.DARK)) {
            setTheme(R.style.aboutDark);
        } else if (getAppTheme().equals(AppTheme.BLACK)) {
            setTheme(R.style.aboutBlack);
        } else {
            setTheme(R.style.aboutLight);
        }

        setContentView(R.layout.activity_about);

        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        mAppBarLayout = findViewById(R.id.appBarLayout);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        mTitleTextView =  findViewById(R.id.text_view_title);
        ImageView mLicensesIcon = findViewById(R.id.image_view_license);
        mAuthorsDivider = findViewById(R.id.view_divider_authors);

        mAppBarLayout.setLayoutParams(calculateHeaderViewParams());

        Toolbar mToolbar = find�\�U��_���#ZM�0A�	���T���й����zG�w2�A�`��w��	����/s�2�v��̔�Eu��L�(��![V5�ι�{�V�kl�h���漭����m��n�,j�����˭cMs����=OqBK������í��c��6���S�G5��$*����1:�^%����ĭN�-������EP���p�z#R�kP��
�TՕKM8Y�*�d�T�d�`I�y��eL1|��آO]�[��u:��3��/6��@�gEe-�:��gEa����`F#�=0ȭ�+�3<D+��T����fv?_x+3s�QJ%uӓ�_�ls,yJ"�E�Hӱ­���;r�L���?��Oj��X�\���+����,�s��t�X��gk3�{S`�dR���f ����w�d�3�S�����<]����t�2��[��Q�T�t	S
�����Ew1]>O���v�gw�AУ}d�NȌK��H�������,b�g��Yz�����,�2�n�9B�Q�ZE���E�"a�g���%�`�'_5Fa1�/�?I�s�OhS[�Aڕ3v���^'�}4Ѹ�v�Z�G#��W�(���Lř�M�
��CjD�l�;ߩ�I[��͞
�ByA��C%�m�ׄ|���ʆ��A.�^���=6!�~+B�H���4l�Iۘ���q�{�I(PJ�� ֲ��]ND!,�:L(�O;c:��ǟ3:����K��G�r1-8s���_�ӥ�;��$�)�t�h������XXN)VP��!<�|5�D�Y���k�k`p��;$׳n��x�4��G�����+�xҙ9���7�v_=5:fb���ت� 
u�)5�S(U��o�������Tzn��3G��H�Q�d�`���g��9,�:Y��!�-�ѹ�'���qxYK.r�oDxDǌq���=��WF����OQ������y�IW2��A� Zϊ��3�kmO!s�:
kn�c�RU��U��@eo�z1tZ��P�^� !!b4����$��amjY�^���U��G���������`�q�ĭ���?'�&��k���.�9��t@R��@n=��tes��J��)w��BN9�m�:��&���Y.C����m�����W&F
RFOx���B��h�>�U��s�u�� �Q��4������i5�fi�m�?����['�N��d�/�`sC}�]-;5�/��n�[���.��Eu�����y�l�ɹ���2���v0��ػ'�$���*.�:�5i�@ɇ�Lv��B6F)�Q���T�Y�h� 7�bO����g�d[B�ѥ�
�y"�*U���O �s�/�Y��i(�HA��KB_�ʰ|��'���W|�?�-�����*T)9�"޽)=��v���)�$�ңʘӷ�0	���.��=d�b�.��uUb�Λ�U,�fm[+�,Sr�?}訬����wIP"oFU�[|��`O��zH��	J��\h��S$�,�N�'ܩ�:��\���y_%�]/=6kq;�lK"$'-�6i@֖Y�*8q(Qs��6����J����^��k������r]e�-="��?n��w��㜧O��~��J�-��
MR�>��*�~0�v���������HeS?���|G޸S )�m��-��;�堁��y��קC�j�Iq�T�U��2�ޔ �L���\��؍Ž8�ʴ���:�Q��{�z5w����d.c��JcB�ط��_�b�,�0��5
5Ô��Z�y- ϳz�m�P�|X�ژZ^�f4,N�Ekq^�L�T_A乁�E8�wSؔ<ȶ�G��� *��&՚�|��mࠋn�5��[�Hž��r�`ܐ,�\��ȣ��^w6���as[�(�>�A����z��EE��"��_��OҬ_��P*H3�7�UGj���K�
_��i� ��T=�5=��(hIQ8.��ˈ�{��~���6��zp�g�-�:�w!{'���CF]4������.��ttN�1=Uh���'-�KGS��� #�_~R/[��70x�Mt@�[%�88	Ą�ˢe���\k1�Y����!��A;�$�� ��ޘa��������l����2�O�����:ߌgz����tV*$w#@/}����bs� �i�٠ x�Μ��(vb�B�>?�S
u��-?l����2C���v�}߇�H��)�����|bV�q�[��S�L�z{� C�y���w���L����m������ 2̗��{̍.�����l��N0U/�|"?O�%�Ϩ$����;�v�1��'�^����X2T��-��g��ך��w�aR����4�V]��>z#���rosD�;x.�1�7T�H����([N^�9��dD��( N0�ן`��^5��IZ�#ƍ6�?�^.=���� ��F��T_�>�켄�Q膯R-%Cg�t��!���W3��_���	��]�'6���_���R��{��V�2T`�}c$��~����om�m@��5 @g�r�S�י1t�r(�b{ �=X��O� ��:�-Ĥ8�B�Y��@����GhgN�h
+=#�������Z�Ϡ&�����}��<��`�⼏�Klk���� u�"�ѡx[�5��p�>C�%�Q����l��NJ�
/�}�D=PB,'*�a)�S��If��ѤL�h�8���[ ��Q�ͥK�ծ�㼦_A��`��F���ư��Apk|�ţX�>Gy�'ljS�u�G��K�w
-�7��Gs_�:U��6��~����I�-��K�/?LeK��8�!�fl��97���:p�P���UޢxC3�\�8���k�>�ңS�d�vXD���0Y"�vMMVf-B�<7�͜�m@�D^^a�2u%��>���7��Ʈ��.��w�*VG���(�L���H����e���V�c�jR�MT��-
o^}M|�!%��j!Ա�w]��Z�v86�v�*���ž@�$����l��a�醪�b8S��+�i�]�%߂c�4��1&��@����|���s�T��t�Z�=���y�G���/���wHb���]�����Hk��5���P*�-��u(N��[[[r^JI�@�����Ŝ��;����M��E��Y�ͼФ_uI:�'`#(/cm�N��P2��ל'HV �T2p�p��fE�u�)�<��>Z�%��ѫ��b���Z��@^g��]60�'����H��%׶ƾ�1J�|؊�\�������	���g|l~���	���s2 l��ƃ�I��v*ǃ,���/H�0�Fs �r>�hrm���lh�GlG�Z{�Z�g"{�7�A%K/�0G[m9$g�b���,��8ߣ{��H�,me�����dQ�q�{�yH��RW��m�\I�r�[����A�~�H`ͪ\��_�$_P����Ǫ��� �����Q���W����5��t9�B����uI΁JV_5�I��k'n�
i��� ���D�1Ƚ�Ϙ�d�h���*m����$����S�u�:�4��k�Td�'=>����2�M�~`���5	��4q�+b �<�����=��[ 0:�	��������y�@b�ukU=g�\hV��Ϡ��nS�?7����ݾ\l(������������2�)+�R(;Z`Q�D�Ղ]�+�f�Ngk�y�ڽ����6�;���G��%��� ��jT�V��E@���K����/=�a^�W��;�A�_����+Ě�dF&k�Q9�W�,�����O��N��m���!$Z^�(=(�(��i�qy6�	F���꺰�#�%g�c=�u?d����]���x��5��~�����q�?gS7�gC�e���4E+mW�bd�� �e���0p�F�;'l���ǵ���Ø�B��o����gB�Yw�1�b�h�����B�}�����|��m���o��K�*5�g����^l:��ɽ҈5��ϙ����� ۃ����(���(kb��K��d�}6�^�?���Ť�qp��ʿ��%s WBB��Ѡ��|�����W�n��3�.,-ϰy�|~�pv ��g"����s׏+4�$�sf�/�I���ƲR=^�+���Z�w�%� �&�A�~�MJ5U��B�{X,��v}�t�[J���P�O�'AsT�n@z�E�}�wK#BR鞶�&�����%�v�����ï�,hwD����0'&i��N=��8�G���/ʛ�O�3�1�IW,���S�i�c���2B�B�6�׻��Z���M��&u�'����'�h�?fm��ڞ��0������y��}��6��,�YȎ�)���樫�g�S�/����|C�w�l��Y�Dh#q�3I�;�]�� #�W5Hj	Y\Y�Vx�U��v�a�{��c5,�'�ᡈ}jj�����|K��##[��w�{�m��X�aQ����t��6u��>@�m���(M�{6�3 l�/����Ԍ��j���	8|�3N�Ϥ�}M������!;IR��x����{2�
�K��K�T�Nsk��8v����!_:~D�Z+T{b@�i�bL��*n}Zr��]F��i�9%P�2Q����{�&��ϳ_����rS#��S��������^�V1��z/1��J���p�!W��WnΠ�d�����ve�����}��v���+�|y�N�n�U� X�j�' t�
�����\)�Y
U�(����W�t{Jy�G��Ԁg)V�4W'G1>��u�kr��C܃�]���Ցߜ�|{�>��v�}�4ݠi�����I�Ϫ��J��q\����CǞ�Ǒ�D@p��\8��x`�!S��s�P8G���y�)�9g��j���*:�Jg-��>�0�ǁ����1.5�D� �D�A$�m��gE�gi�Wv��t��V��؇m������a���1������KT�6o�ӰL��gi��6�����t�� Z�ܗ�x�̋95�b��BkEm����);R6�kL%iE���^g��C��,�'grB�k���-l �Җ�D�,#pv������Dd�����O�	d�6��5���EGB�E`i�n��P����"�lV�UxD��⠯�$�h�{"����O!N�����w����]���l���1|~Xq^r H���)T�s�7�p"�۴s�y���G��a\�/j��cq�%����Ǩ#r�=P`�BC����J���vw���N�l�nݕȡ�Cf2��p70�[7�$}�[s�&�2�M���Wr�_�.8,���>C�~�0߈5E��o�3�/�n�5L�j�n:��ټo�1��K�֗Ҏ;�]����ė-�xF#
�L���9^Pu����m3_���'�HC.=�����L��l/�x�^7�+�r�>�Ah�odd9BX�`��u�4B-"#nZ��x쯂�AZ�5�[I	�y���+F_4 �����u�F�ʉ�L߂^�8�f������� sT��Q����Q=�JaQ���0­[��@��"�Ԝ��H������I�GG����m���,P���k��R���G��R:dV��e��	 ������a9<赙d;+X,�:��6���7q6b;G���픯���bu�F����]�Ap�ҿWղ�_�rĎ͓�GW�)02?��̑�9cଜ(����L�M�Z�g��U�~�e�R�HJ*A�fq*�nʽ�s�3�L!�`c���9ue�� d_�T��/��<����Rkd�{���֧I Ʒ��՛A����������A$ ��R*�=t*F����\ս|�&DQ�^�Q�h)��������FL �`�5�Z�*.�uo�A@0�U���;�M���S�z�h:$�x��m0nP�H����/�1"f����sN+��jzo�<�zӍ�m� �Cb2��,��?o���I��*<N�d���>��VѾ�m$;��z���wb(��᡻+�=b�tWT��n���y�����J��>� ���L�A&���;*�X��i�O�Ms��ӖN��`�?��ZI/���[=��ڭ����c�-�[�d�!��2�Q����'��5]����Hkp��eV#���`��c�?ȟ�Kxim�7�iX9!�>�Mߡ�ӮC���b�L�᯼������U&���o��d�S��K)p�ۦ�r��6�9V��{ʉ<�↠�9UU]�K��@�␳���k<��3�?	'F��EV�o��G�`#E 	��1����j1H�����\�N�)I��]����.!/�(�Bew��Z��O����[�.#�C,��ݫ.�(<�JKS��a�\S��Ԃ�W_JW!�}���b�1�����=��a�/R U-(M�i9Oס�yT��f�
�m=$�)�b�4WH���+��*� I�����Ce]u���*@��
��]4I$s� J����┗e�ɊZ0�A��c�:��TP��@2�C�=b� �ː�ؙI��\<�u4�EOt,�ή�E(��q�Xw��M�Ω�#7��w��M��Y�?�
�SĞ����fvf�1�ϋ�N
_�ǯ�����V8.�jcX�0�9UKJ�!R?Ν�'�m�8'���֏z��6�#��G'��QF�iOVsb���,�<:K���鑅H�O0��u�5$fi`5�s���E�%��d[��t�x�b�O�Ke��#@D��2>����oL$�A((�w�,xY��A�Ƞf��)�d��JZ>�Id�P��&Ȃ2�o?X9'�9���n�*����D,pd�����:j�Uu����hY�DSK��~�}��(�П\���3=Az�hĶC�����X�E�"�^�~6�S��%��X�fJM��*G�6�q2n8�(�
#��"χy�=��2b�a3��)�