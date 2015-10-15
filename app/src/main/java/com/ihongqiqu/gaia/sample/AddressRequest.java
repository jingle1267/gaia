package com.ihongqiqu.gaia.sample;

import com.ihongqiqu.gaia.request.Data;
import java.util.List;

/**
 * 获取地址请求实体
 * <p/>
 * Created by zhenguo on 10/15/15.
 */
public class AddressRequest extends Data {


    /**
     * errCode : 0
     * retCode : 0
     * msg :
     * data : {"addressList":[{"address":"上海上海市宝山区教委大楼5曾601","addressId":10,"city":"上海市","district":"宝山区","lastModifyTime":"1414377342","lastUsedTime":"1414375607","mobile":"15800885222","name":"张三","phone":"","postcode":"000000","province":"上海","regionId":205,"usedCount":0},{"address":"重庆重庆市永川市第二实验中学","addressId":9,"city":"重庆市","district":"永川市","lastModifyTime":"1414375427","lastUsedTime":"1414375278","mobile":"15043685888","name":"李四","phone":"13552558113","postcode":"108563","province":"重庆","regionId":2107,"usedCount":0}]}
     */

    private int errCode;
    private int retCode;
    private String msg;
    private DataEntity data;

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * addressList : [{"address":"上海上海市宝山区教委大楼5曾601","addressId":10,"city":"上海市","district":"宝山区","lastModifyTime":"1414377342","lastUsedTime":"1414375607","mobile":"15800885222","name":"张三","phone":"","postcode":"000000","province":"上海","regionId":205,"usedCount":0},{"address":"重庆重庆市永川市第二实验中学","addressId":9,"city":"重庆市","district":"永川市","lastModifyTime":"1414375427","lastUsedTime":"1414375278","mobile":"15043685888","name":"李四","phone":"13552558113","postcode":"108563","province":"重庆","regionId":2107,"usedCount":0}]
         */

        private List<AddressListEntity> addressList;

        public void setAddressList(List<AddressListEntity> addressList) {
            this.addressList = addressList;
        }

        public List<AddressListEntity> getAddressList() {
            return addressList;
        }

        public static class AddressListEntity {
            /**
             * address : 上海上海市宝山区教委大楼5曾601
             * addressId : 10
             * city : 上海市
             * district : 宝山区
             * lastModifyTime : 1414377342
             * lastUsedTime : 1414375607
             * mobile : 15800885222
             * name : 张三
             * phone :
             * postcode : 000000
             * province : 上海
             * regionId : 205
             * usedCount : 0
             */

            private String address;
            private int addressId;
            private String city;
            private String district;
            private String lastModifyTime;
            private String lastUsedTime;
            private String mobile;
            private String name;
            private String phone;
            private String postcode;
            private String province;
            private int regionId;
            private int usedCount;

            public void setAddress(String address) {
                this.address = address;
            }

            public void setAddressId(int addressId) {
                this.addressId = addressId;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setLastUsedTime(String lastUsedTime) {
                this.lastUsedTime = lastUsedTime;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public void setRegionId(int regionId) {
                this.regionId = regionId;
            }

            public void setUsedCount(int usedCount) {
                this.usedCount = usedCount;
            }

            public String getAddress() {
                return address;
            }

            public int getAddressId() {
                return addressId;
            }

            public String getCity() {
                return city;
            }

            public String getDistrict() {
                return district;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public String getLastUsedTime() {
                return lastUsedTime;
            }

            public String getMobile() {
                return mobile;
            }

            public String getName() {
                return name;
            }

            public String getPhone() {
                return phone;
            }

            public String getPostcode() {
                return postcode;
            }

            public String getProvince() {
                return province;
            }

            public int getRegionId() {
                return regionId;
            }

            public int getUsedCount() {
                return usedCount;
            }

            @Override
            public String toString() {
                return "AddressListEntity{" +
                        "address='" + address + '\'' +
                        ", addressId=" + addressId +
                        ", city='" + city + '\'' +
                        ", district='" + district + '\'' +
                        ", lastModifyTime='" + lastModifyTime + '\'' +
                        ", lastUsedTime='" + lastUsedTime + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        ", postcode='" + postcode + '\'' +
                        ", province='" + province + '\'' +
                        ", regionId=" + regionId +
                        ", usedCount=" + usedCount +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "addressList=" + addressList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "data=" + data +
                ", errCode=" + errCode +
                ", retCode=" + retCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
