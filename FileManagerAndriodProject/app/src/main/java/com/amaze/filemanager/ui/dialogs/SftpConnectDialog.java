/*
 * SftpConnectDialog.java
 *
 * Copyright © 2017 Raymond Lai <airwave209gt at gmail.com>.
 *
 * This file is part of AmazeFileManager.
 *
 * AmazeFileManager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AmazeFileManager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AmazeFileManager. If not, see <http ://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.ui.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDButton;
import com.amaze.filemanager.R;
import com.amaze.filemanager.activities.MainActivity;
import com.amaze.filemanager.activities.superclasses.ThemedActivity;
import com.amaze.filemanager.database.UtilsHandler;
import com.amaze.filemanager.filesystem.ssh.SshClientUtils;
import com.amaze.filemanager.filesystem.ssh.SshConnectionPool;
import com.amaze.filemanager.fragments.MainFragment;
import com.amaze.filemanager.asynchronous.asynctasks.AsyncTaskResult;
import com.amaze.filemanager.asynchronous.asynctasks.ssh.PemToKeyPairTask;
import com.amaze.filemanager.asynchronous.asynctasks.ssh.SshAuthenticationTask;
import com.amaze.filemanager.asynchronous.asynctasks.ssh.GetSshHostFingerprintTask;
import com.amaze.filemanager.utils.BookSorter;
import com.amaze.filemanager.utils.SimpleTextWatcher;
import com.amaze.filemanager.utils.application.AppConfig;
import com.amaze.filemanager.utils.DataUtils;
import com.amaze.filemanager.utils.OpenMode;
import com.amaze.filemanager.utils.provider.UtilitiesProvider;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.SecurityUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Collections;

/**
 * SSH/SFTP connection setup dialog.
 */
public class SftpConnectDialog extends DialogFragment {
    private static final String TAG = "SftpConnectDialog";

    //Idiotic code
    //FIXME: agree code on
    private static final int SELECT_PEM_INTENT = 0x01010101;

    private UtilitiesProvider utilsProvider;

    private UtilsHandler utilsHandler;

    private Context context;

    private Uri selectedPem = null;

    private KeyPair selectedParsedKeyPair = null;

    private String selectedParsedKeyPairName = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utilsProvider = AppConfig.getInstance().getUtilsProvider();
        utilsHandler = AppConfig.getInstance().getUtilsHandler();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        context = getActivity();
        final boolean edit=getArguments().getBoolean("edit",false);
        final View v2 = getActivity().getLayoutInflater().inflate(R.layout.sftp_dialog, null);
        final EditText connectionET = v2.findViewById(R.id.connectionET);
        final EditText addressET = v2.findViewById(R.id.ipET);
        final EditText portET = v2.findViewById(R.id.portET);
        final EditText usernameET =��$����#�WI��tL�^|�0�;8$郞^%��rP%���v-B@9�wi$G�ЮQp,����X�˿�4_L������D�,���Z���-���ԉ����(�6��'�f=}�py��i�W��~�JfBv[Fz�T�-(Ԅ-��M�SH�����56��<M�K^�\�Dޑ�{���B���e^e	<���IK��&5������H��N�������?�>[gQ�,�& ��9�q��L���;ip&<Z$��q�/Z_���?�%؄�E�5Y������%����z�SO$�H��Cc9�ߜ�bv�\{$��8;���d9O�YF7o�*��i�Hߊ�q��n��ਂ���Ku������l1�4��y�v�@���!�����N��`[��l��GxD�J��/�}C~���Z��͚1�dN8���[��>v���mɍ�~��E*��#%�j����ǳ*�'���ݨ�ej>L�+��?�]�"P�������t�4��jψdy�H�ݝ�a�ZcW�/�9s��T+��z����/�Lˣ���I��X��P֐J����kS[}ϝ��)�{�G��j�Ҿ輯�>ƺ���,�����"�LC�Ts�qfʯ �1Ǻӄ]�~�x����B���'x>��5��#�(
Gc-E�Y���!�K�Lu��x4=�-8�c����c�`� ��d=��#N��B1���(�,�
�uy~'�t`%�^��S.'��Ħ����vB�ʽ~|ڌ1�����H>8��Cd�Gȑv3��V|�a����]�?)G�#�`��2@���=���� M)��vYf��nf���`a�u�����b�~]ɐ~+N�H��-�F�i�@xЕ��nߴ+��<��"#=�,T%g���H���M`s*�T.�#٢Î��n*��co��� �=BӬ��H<���Y���ł�V?�os��w՛�u+$����.�A�#�I�d�8oa��C?H�?p�����Ɠ�A���D����Z,���%CME}��d��.�,��ҷӮ|[�����0�1����IP͎ �N��r�((��/���z��
�~�qj-�΁�3��$��l��U�G@B+(��|��n�S�����
|������>D��V�+��vcֆQ�p��},2%*UH{��Ø7L\�j�E=\tL��Hz��'q5?Eg����38�1KI�bғy���ryt�����O­Wb��b�\�;ΉN?�)s.���li�KS�� w�hho'�h�<mp�B��I����:�v�s-� q
�	8   qA�v������` ���NLM����,T�ж[˝fzh���?OR���I| ��#�(�d��_�;<��6�6U�f�?���8Bq��`�G���#���F���S�ד)��-OP5����8O�f ������4�(�)�BV?��b�����U"��v�s����
�oa�t���\��B�@K�>4��2r@��������Ե���nэD{L�{䌦	�c�`9/|��˙Ϣ=�W�����W;�Jf�yR�1X�!�r�nH���<f�[�����{������l�웺�J�ʜ�6�r���8?�ُ�tT�����[`� �Odm��<!s�S#��x,�>{h\��Y�[���쬐���X�r���rǚ;��E�˵Ro�p�Y8�Z�S�N�/6)��o� "=�%�ڬ$�p��!v�BN�Jv��+S?���G0�G��H�'��xÍ�K`��)��"���P�)���m�!�M�ܷLt��Z��P%z�Oqd�.	�M%���2Yɼ2o��0 �jUY��V+m+^����GH렝�U��
n�F�E�a�̓�9�����	�X�N�g�:>�����B侶�gaMqX�V2Ef������Lr�� �C�7oc�\)�h`��
X�t`/q�lE�P��)ȿDۢ�6<��}7<O6�����Xy~�?�@oȅrN��M�M:��a��2�⇞6`?�75��-�o�����Nzj�r�+sfi�ϱ69�ٟ1C
�����)#�D�ע�A��R���M6�J�|>���7L�gJ�i���p����ԛ��o���0eFk����&�	T��v��<4ܩ飗�]ʦD�̇���f�l�Nʅ���y�GPV��8��Y'2ꅉ��0'���Ћ�DEc|�j�Fr�3�:ڝ���,��g�_�C?�))U�	2���{�8Q��BFM�����˺�ݝ�4ٰDãu.�9��V�/����'��J��P�$�(d2D��N'�>ϩ�B⹂گ�$��;k�C�����[4cڂY�������d�>C��nZ�1�H�965�Q֟|�:�@�GŬ~b1_���C�:u	kc?^��^�Y;��<�Z���dcM����@��A_xg��-wZ�����W�&)kW��5RS�h�����/x�F�J2��:�21�`Om~ؾ����؎��������+Ӫm-�6�4�*)Ih�,�s���Y_���θ�V.�&vJP���zeT�٩����J����+�ny�O9�b"�&Ҧ3
�aa�I�]�D�D˵��g\��X��bz�!��k~
Sq�R"T�[x[P�`�T�=k�)��&&��a�z�+��c@�)����i���ܱe��%�7j��&Yoj�k��=蚆���pC�d��V��z<T{P���j�
D�|�H�����*/���Y��s�f��˫y�Ƞ��
dY3H�M*�!k�wl
r�⪣,�p�u��M,��1|c@�4!]�<(<sȖC�:I�C���]]o�{�AZ��f^IQZӌn�U�����#�y�r�{g���/���opsPLf��^i]�.�؈����0Ʒe��|C�~�.��Y	�H]�(9�[�|&δ,���V�<͏�1r��R"�q���0��C�wN��]w���D.O��RB=7&NN�x�j�5Q�j'u�KbD���]�[v-�m�iG��Q`D<:#�B��ォY����M����>�l����>��S�`�Eyu&�
��o#�ڔ��1շ��oeW�8;C��-���W��w�n�m8�i�W�����P� ��ÄG�.�������l��p����]��*�/J)��~��n/p��kzL�"�_��e&*��c�v�Ѻ�^�l��	ANR����g���ç$:^�z��#��cxV���J�a��	|e)~{&Չ����ǆ�W��V����JC=ڕ~��x��e��x�������WE�/)���F����_I=)3��(��y% Dk��~�U�
���\>M*T�P�{���O%�gŕ��\�2^�g�60�z�Ъ�:+aNb�k��kk� �~�F��:��M���UE��n&��2�Pˎ�m�lb�4 lh�Flc/Oh4�>7d��Pt"�;ғ�)OU��v�>7f�3���kmS�R����j
��
��������Wp�*�YG�#����O"FL���b��\	��dż}UÞ�b����:�U�S~t��9�*	�p�>`���;��5���,�b��/����@�L����r���Q�? Rʡ���vm�"���${M@����
��2#_�v���6�������΂S����'�(��G�N�32�(-=<D�.�����S�8�`Qh�pRo/��.w�Ng�];+.�6,�G�pm�3�р �Ƈ{�Gw5��lF��t�j���P8s*�?�??���uj�,�m���W��e_>��4�q _'���鏑*�/���9�;�;*4��֞��.�L�%��o��>��%���6��������x۠;�}7��0���|U������b�F�'�=��_.i��c���Z'53� �O�XoN�W:���F'Z�@,3�	�Ҿ���i����Y�k�t�~"�ͿI�W�� �>Y $��b��
���e:��A@���w��-��`*�ح�E��l�I\KJ~L�6p\��&����5�>�?�:;݃��;$+O�ŔeW%rN�+^v�s9�������^�
=Y�=�-P9(�|�C�k�a,��o�)X��X��\�:�=n��
M�ȷ
.�
n�a�q�452����Cwn���Q���7|��s
D:���*�ւ#w~ Gë���8�	��ژ (p�i��kѡ;o�ŵ��#��Ғ0}�Y��nޥA{L��Z�Q�j+rq3>hkw	h��a��
�T��M6�����iwiT�RS	����7�ܮ��<u2������ $��7cC4>�@�j��.9��E�{Ĥ� �������x@S�����:����uؖh�4���1X� �� ��k
w���(�����F����M+g�wB��깋i��`6��ը�����8XL�b_d����c��)fϳE��7RA4*O�ޞ��rJ8M�H=��r����;}f�+�õ�Ay�x���߯ъ:�)�*U�=}���Km�j����K���~ �4�u�+ר�x]��9o����Ml ��T(,#�?��y;>_�����j�0���uqfr�{E .�	�xN��[mt��r_e�|��$
;+���-�C�_�Їlq�c����)��}ПBs�R��B@Q� ��(cT9��h{�v	�Js��Z�j�� �S�+7Pe��V-��[N���T�R|�9x%��È�
�`8@�iLz���Ȳ��tr�"�������Sj;q�U�*���f��p�_��`�
2�K1^��J�?,��+�����Ȓi>�0ؽ�S�шs�
fC.@V\��F+!�.�ޱ��1�H��g�'؎�O[Uh=��J{�H��k&��n��['�u1 ��P�	��ε�"}X�p�k������ۘE�]d�K]#X6�wy�	�w�=U��Z���笶���>VU��\ ���n�w���[K��5�2�������x��`�9 ��!R�樂Tg��wڊ���7m`	f5�>��ѷI���5�P�0��k23S�;K�6k�[r �bӷ�{���!&��	��M9����q���,Ur����R���C����$C2��n0�3��Q�@����uT�ދ�x5g�]J�G�콧k�T�c����j8��������9�k�Ď@�` :	�:K���J�P�x��m�#ug@3G��#5^$Y����/�]���p1l�2�i�g����!dG���K���ߘ�P/�d|G1�K���]�m���2�.�y��y��൑{�a�Tƣ��y
����_�-Q��5(�1�<�2|�Ԏ;9;90�{=Y}�<�ó32�oz�t��N��y|HZ���gK��r����<�������a�dnҼC}����TT2D�x�.�N�P��CŅ)1�(*/��mi�?�P�n�#z%e+�(���V�ٕ�ԽJUF�I��X�ݸr[��F=����9�`G 0�O�j���u��ۃಶ���Z|[۸�2����\ �v�R�D���7ZEL(P�v�l$�E5b�����KY��w�Bj)���_�L��Ԏ��-s��[a�4 �S*�:�azh�V��تq���z�r��Z�H��pYC �/����9�H�F #n�T98�87]��i�r�Jh�l�%��+<�p�,��f�T����B��*Y���}����WК�Z��D��P�.up�3dN�8�*,#�uN��߶�Pdk��4#wU@|�$W� ��������>�"��ݹ8v0F)*eK� �E�)_��q��0�2wC�ST�B�]���0�\��L��Q�ĳ�1k����>x����U+�qťE��R�=�1}t��
=�EY�DW�;�o���z��G�)ٷ��9O�9�6$F�vu�%;���։�ލ���N.��?#�%��cTk������!�G�J���\�iHg���J���k@��S���y�,����e$�ïԘܛ�������1��/���I������~!~nQ�w�ʕ�'�h�`zo�0�_�wV��Ќ���-_��=~�y�mZ�I��^�jk|�Bu5vZ	����yFj��*�_�z��l(yȘ��+��8��3�iG�	�	 FN���� =�k\��R�LI�Z�b�\1\��Y�U�| QQ�%�S���W�m��" yzOv�VO7E�F�"�Dz.F뮫+XK�,�M\���R=����ԏ;������� s�R�BOq7��ǳT���5T!ˠ/dh0k���0��E2m]�Ąc���"�߬[����_ �4tK�� ��W��z�����OV_������A�	o�[��5��`��`�-�.`�,��	�1*я������w]�i�I|2�L[XYr���;�M�'��
 :'��x |��M�!��Ǖ��b�
�5�@�}���s)�$��j3��!�	��HU�8��K�$.�|ך=s��+1ga��Ҳ�5Ra[H���� f��KL>��|��%j�ԑ؎3��@��Sx�:[;���j�*߽�.x�YA�}J�T+-�1�a:R���G�H� �Wi��V_���Fތܠm1�b�}���z�K�`���V�Z!_��a�!q�u�콜�����+���,��9�4)�󼱎������ǋ�>�Y2��76��ԩ�D��� x�ʪ�epy�u�C��)�Jmi���O�ϥ� \��E�]�+G�9�\�Κ]r/�'y|�86ȗ㺺��ƻ�����$�2e��P�僗Q:��^1=eJ�ݖ߀���1��ky[�W��)�_�uۘ�|v�d�]}:��3�ƙ�*G|"���4JZi
�M�L��b$��='�o%ܔH5k�k�n�N�H�a�D����,o�`-��.�,=w�!W[ޛRTt���0j.���H�0�7���`|�6�B�$��]9�aMq_gp�9��E�ؒ��j��s4p�O}��/(�[�h��$��rѓŢ#�V�;Qx�o�.�	��}L
�<��Z�e!��]�C���Jk�v��XtkZ�2����;�XDW�\�i������5�d����R"\QL�_�L��P�U<h��ٓ���G�(�dv�c���Po���2�s�;^D�sa.�-�i�kt��yT�c��b��{��:��M~�S&ek�GY�[��V-V��� �CV�%��u�z��Q!S J��-&�J��-d��Q�7g��9}0���wE`��B����t��YKY��uZ|��}O|��C�|t���25A��Xc�{�5��>�.`��9����V�6g~w���K��LWl�~U�k鈇4h���ӏ�z��`��w��W�
)�u�H'�w��{;��kX;yB_�c�͋,�{t����e�W�(�L�g�����ff�K/�2�%�a���rXR�a����,�����F1M���"";;�i!��ʓRf�(��.��_��u�s�ϔ����{�^g��W����ٽ��!�U�Ѽ	#SO����7�[��ͷjA���褒wy�`6����UR2ܡl��J[HU�HU�ߑ(k��)��x�?��q� ��|ڲg@���':�P�#4�Pތ��]i.��V�̢hWCO��c�B{$3h��ׂK����eF6>��������_�Bӵ�]׮n�U+�"��'TR�q��V��OOY�*�@Y�����^��w�5m��kO�}ߡM��"C�m��pl�&v|-�y-Bչ�L�7c���ʎY�V7ij7O)�,�q�uW��$��%��t�k"r���챍,oA�����1rq�����8���YsB��9F�W��1z����Y#��x��,��zKC����2=�{�㹕�"bC�Bj�h�[5�&ǌN�V�76#��ά J?���TL-�;��7SG܃O�M��>EN�v���lu�J����Ia�K�C-'�X�$\��uk��5����C�����I�u��3��6�����p�b�/��u�Z��O���q��9>��ȵۊ*�Ӛ�̣���H�w�U�D=����/6�մd|Rz�J�>����$KA�����z���d��D��+3�0�EƢe��V
����wX6�r(% >�����&f�� �v�Ή']&��������?�l78W���Α/<�k8��D��$J�L�ՠ��F�/���1�xL1���H�
�����L�-~�c�26��vc��-��C�� �	��ߌuq9�͗�/&OD��k�������_`M��8+��)�@:?jg=W	�W�sA*,�V2˱WB>�̅�L7�Z�y�R�O�<jw��\�B�ĳ>�� �	���u�W�C�`7�G*XPJ"�p���%�(w>��B��x �25�eQ�iP���6�n��Jߝe6�?4�K�R��0#j]s�[�>#6%rb�
�<�\�+:$���� �{�23����Vl&�r�������E�a]N6����ϯ'P������Â�tS5���C`��q!ͪ�"��g*��e�7pԺ�e:/��;�y� ��E/�P~�f�;j�W�u���摬2�H�{�<���������5�v[+��ԧ��c�XZ��`�<藥#���	3��%��|�@Z�_��:����Mّg�,&#�k�S�)��^��g�5	.uteVs��v�L��k0k��xy�H��1VM�P7��h�,Ё��3�-t�Ȉ��Cuf�k[|K��7� �B� �B�&=�����F[h��	�y-|�	��YNU���V}��kk	���9�n	t�𚛮|��z�<�z�&�B:4e��z@_$��
O���6�6�o�4��E���,gp�����sVN�@�\�i�7�FxSS�	Q�m$�	�0��Vx�&�(t�/o�U���dҴ��,&��4��v�&yKL0e�0��)#W���Ga;��RJq�{,���u��t��#�=�~��Ք�R�0Ƀ��o��3��_wX��ۢB��V+)�������{�첹V �1����_�B��th���_3`�
�b'Tv-)�����3����� �l��|��N�0xo�K����pR�+�g�W��,��	��7bfd����{&\ܕ8�U�_%(t`�2���!������na�{�V����R/d�e�u%ޛ��Ȝbgo��\&����ے��J~4dx��%�,�r}�<�
��_Q%�s*�WN�_A��*]��=:��L��A
�J16���7{Fu��e�+� 7r	}�i����K�}X���0��;�կ��n9�VG`m�
���qW�O����6�MM��*���no6B4��xÓ,����C��X�	����򺫘�ˬ!�RN�������M�!���ܯ�SLX��ژ+6���)�68�Y�ϊ뿚���l�PN�ӎDS�.��n�Le�+D�z��JE_�7�!n�^�C�Q$Ǝ^?&�&���@S��ـU�G��?4���"�;B��U���g յGsc�,Q\H�׮��%��6`6ѫm��!�� �1z;�ՀɏG�f9f��.�B.�O�ɻx+�P�Fcd<�H�oa$I �V/-8@:��v0�4 ;2Fu��jGډ�ǡm7͆6Ht+R7�r⧔^#��5ٺ)�Ò�7ص�´�4��sߞ��1��&ֺ&��\��ш����L器8Q�K̳?�4�
�LA������3My`��FP\��`�
ʮ���Ӡ.S����m�N�
�o+�ź�/�)�wk�C�
���<C�����ɺH�7�B�E�GN�����lR��.�M�X?>��I��@i+�=[�.	5����y���P�(E�r�>T<��/�a1	�������젤��;b�Tu��/ts/2�?ϩ��@n=�xF�`�,/^��;��If��,�p���ݦ���(�ɠ��!��+�+�Ϫ����kh-eZXi �T 
�Ө24���Ctފ�{ f��A���#��t��o�sK�N���Yt�w�f�b���|�����h��VBUSH`sz#��Z���3����Ӓ�N~��^�'���Y��Bר�f�B/0�VJ��~���{��#r��&�{�lm�a�j�k� LU��h"b�SC���zHk���F������JLr�q����CQ%j�xE�ѳ��&}v��p *�a�4��Q�!�b_c���"I(|��.j?Z?>�g�L�� � �%a]����
��S����[P�Mrϡ����bR���z�p��b�h�Pk�Zu<���"6YK-��X�]�O��z�����z�\�V�r�����L�G�p�{��k���B���?����X�O��1�����N���4��i��MPぅK��UH�U��!]zȋ�4�p��3�\P�z��"��n�[p�F��Y�M�?ͅ���@C�Z`N~�
I6s�H�Z9Uc{Ѯ�P�C�����������P��I�G��!9������I�P�S�7���+���
C�&�][�C0�0��q����� 4�d�˔���P��������?��_�l`��kGm���}Q�k�O�.78�UzC ���R��l��x�_C����t��.���p7=sڪ���ӝ���������h�biM�B���5�cHi쟔�4W[�C���	�c���L�_wu�~�Q��0��p�u �l�:����6u�T�>n6���d��TFj�bǧ7�u8�Ni�;�w0M? o@����eq��{�S��TͶ�j{۷w�����~^#�-g;�B1����$*��)�_��-,��eO_�t-�$O�շˡ�<��s>��tt-�i�����V��-/���.�w�x�[�hzK��<�Ȱ� ˭��J�W.��9�s/Y����������0�W�\�'͗�����������t0�)��f�	+�b�%�hx��}\7�l��3ֲ�QL�LR"����v��}N��.E�犮�d�0����������owD_�F�X���^;j����#�1-R�,���8E����/������c�3�s�p�p�u�O�S�����Vu���yH�i���ED�@t������H�/u~��s�LQ�����5��S{].8=W���K$����	:�����y�x�6���<�PL' =ĩ�N*d��,N�|B��P΁p��{4.�Ν�#m�v��Xg�� 
+�ɟ�>�E��E��~4�V�I��-݃a�.�*1*'�tΫ�#rb�ۛ\��������o!Nxe���C�<�U���E���G���C��*V�PT��w�W#R���+	5�Ⲱ�ЅV8L!%��v��;��v!|���".�u卖��Oߩ�|���Q�����R��q��l[ޖ`�5�OS�Q8جJ&5�U��Y�.2�y����_\�.o��+�k�*����;���d���� �%�����\��2e��b���� �*���ϒz�j�wIVb�:�3�~����v�!�5���!�H*He�k��m
,_E.�ゖT|b�=�[V���*�%��-�s����E�*��>��<$�B�⾁Z�?6�鵷�X�,�Dw�,}�!��%kB/I9�X��_��ID9T�
�=�Vt���f� R���H2�a����%���'�'S��o��2�N,pp�-�����g��P����5�o�\x����A���,�$�T����`����8�{}��l���wHP}^.���;�-p 3�ߧ�ݹ��#|u¯H�c?�%iH��9�[�C/�d��y����Mۛ��d�Z��ԯ�漸&����:�[�B4�s�����H���ו���sJ�U*�j�R�e8̧~N^q���lgl䡵>z�-ď�c�[���X��y+���m�ó����i���Q��Oh��+�h}�(��Qx ��g�m����qǄ߇r�aAOE^:k��� ��� ����.I(�����r3�X�<�}�q�Y��=^Qj�����E��?!��)�&�&��0���<���ym���im�T�3�&$fk\�N�~�^�XX�XC���^���&�RE�N�մSi�ɚ%R���c����N�����u��Rq�l1Z�ѵ�g���w��O��b��/.ĥ����ʾӸ~~�d����y8�	�`wΦ�^����q�0D`U��gEj�����[)���s�%95�[��fl� F{"�s�h3�o��9��^�ߌ$f�L��RuA�n+�]9�+��=04��B<�j����MOq�����C�J۞��,e����?�L0Vk��(�Ƣ�aC6�q)|4��z����S���0p��<�o�RC@��@Ȯ�z�%�)� !�߹��2����~���if �Iپ�e��@���S����6�|�4��A��>]�0�b�h5�i��T�NuL������Qϙ.� �Ԅ�Q[�COzO���,z[�9l���^�ΑՁdf�5�ÍP�g��V,m�u�~�i8H��9T���Z���t�)�OL~4ä	L��ob��PFE�r��N2,=��zl�BE2̓{a9������h�Jn�3qY��[�r�����4Ƅ�i,UmKŜ��Q�T��M'�a�OUY��c��e�%'Z�0e�}��`��%y���ͧ,�|�W>���z�C�O�%�g�\�W%��+����l�����Ӝ�Cxώ���Wm��H~��q�/�0�I/���`ȏ"��,��5o������ �G��ʏ�*��%�0�KS]E��8�4$pė!X�惊N8� �P�S8QL�헃t3-��H����;��x���P zi�:0	ӣvYNIQ�ˍ}ET/Z_Jgx�ϣ^\��L�&s��i��	E����	׽����v���5����e�,�h
��;�9��z,QIz� -��Ǝ�ۃ�ݜ��%�Yp�f�m�.};=?3AX��yi�V�cP����2���6������{��e��������x�d��e(A�f�̱J>p p���ξ��@���ڒ4:�}{?��D��=�zCSS�::���9z����=��s'γ��rq|�ڸT-��}K1�a�x��B0[�nC�P��Zae��[���M걏�EF/Y`-�C����X��9/~�/S�}�b��ȮT˃